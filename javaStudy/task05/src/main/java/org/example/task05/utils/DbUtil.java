package org.example.task05.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
    private static Properties properties;
    static {

        try {
            //从配置文件中取数据
            properties = new Properties();
            InputStream is = DbUtil.class.getResourceAsStream("/jdbc.properties");
            properties.load(is);
            //加载驱动
            Class.forName(properties.getProperty("jdbc.driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        try {
            return DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //关闭数据库操作有关的流
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if(con != null) {
                con.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con, Statement sm, ResultSet rs) {
        try {
            if(con != null) {
                con.close();
            }
            if(sm != null) {
                sm.close();
            }
            if(rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
