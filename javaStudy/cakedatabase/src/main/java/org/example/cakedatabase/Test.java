package org.example.cakedatabase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Test {
    public static Properties properties;
    public static void main(String[] args) {


        try {
            properties = new Properties();
            InputStream is = Test.class.getResourceAsStream("/jdbc.properties");
            properties.load(is);

            //加载驱动
            Class.forName(properties.getProperty("jdbc.driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取数据库链接
        try {
            Connection con = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));

            String sql = "insert into tbl_cake values(2, 'fruit', 'no description', 199, 1,'a','b','c','d',2,100,'abcd',3)";
            PreparedStatement ps = con.prepareStatement(sql);
            int count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
