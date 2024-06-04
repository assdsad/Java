package org.example.avatartest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getCon() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/avatartest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root", "wsh20040501");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
