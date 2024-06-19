package org.example.androidfinaltest.util;

import java.sql.*;

public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/finaltest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root", "wsh20040501");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(PreparedStatement ps, ResultSet rs, Connection con) {
        try {
            if(ps != null) {
                ps.close();
            }
            if(rs != null) {
                rs.close();
            }
            if(con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
