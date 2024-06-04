package org.example.databasetest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils {
    private static Properties properties;
    static {
        try {
            properties = new Properties();
            InputStream is = DbUtils.class.getResourceAsStream("/jdbc.properties");
            properties.load(is);

            //加载驱动
            Class.forName(properties.getProperty("jdbc.driverClassName"));
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    //获取数据库链接
    public static Connection getCon() {
        try {
            return DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try{
            if(rs != null) {
                rs.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(con != null) {
                con.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
