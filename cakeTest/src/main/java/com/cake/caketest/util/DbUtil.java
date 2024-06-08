package com.cake.caketest.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
    private static Properties properties;

    static {
        //1、加载驱动
        try {
            //从配置文件中取数据
            properties = new Properties();
            InputStream is = DbUtil.class.getResourceAsStream("/jdbc.properties");
            properties.load(is);
                            //properties.getProperty("jdbc.driverClassName")
            Class.forName(properties.getProperty("jdbc.driverClassName"));//mysql8的用法     mysql5直接删掉cj
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getCon(){
        try {
            return DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
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

//    public static int execUpdate(String sql, Object[] params) {
//        Connection con = getCon();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
