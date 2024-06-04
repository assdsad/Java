package org.example.avatartest.Dao;

import org.example.avatartest.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public  static  boolean findByPhoneAndPassword(String phone, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from userinfo where phone = ? and password = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(phone));
            ps.setString(2, password);
            rs = ps.executeQuery();

            if(rs != null && rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean findByPhone(String phone) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select phone from userinfo where phone = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(phone));
            rs = ps.executeQuery();
            if(rs != null && rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ps.close();
                rs.close();
//                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertIntoDB(String phone, String password, String avatar) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getCon();
            String sql = "insert into userinfo (phone,password,avatar) values(?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(phone));
            ps.setString(2, password);
            ps.setString(3, "");
            int count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
//                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
