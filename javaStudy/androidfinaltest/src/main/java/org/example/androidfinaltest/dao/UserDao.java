package org.example.androidfinaltest.dao;

import org.example.androidfinaltest.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public static String getNickname(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select nickname from userinfo where username = ?";
            ps =  con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next() && rs != null) {
                return rs.getString(1);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }

    public static String getAvatar(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select avatar from userinfo where username = ?";
            ps =  con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next() && rs != null) {
                return rs.getString(1);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }

    public static void updateUserinfoByUsername(String username, String nickname, String avatar) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update userinfo set avatar = ?, nickname = ? where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, avatar);
            ps.setString(2, nickname);
            ps.setString(3, username);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps, null, con);
        }
    }
    public static boolean findByUsernameAndPassword(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sql = "select * from userinfo where username = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(username));
            ps.setString(2, password);
            rs = ps.executeQuery();
            //在数据库中找到对应用户名和密码返回true， 否则返回false
            if(rs.next() && rs != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }

    public static void insertIntoDB(String username, String password, String avatar, String nickname) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getCon();
            String sql = "insert into userinfo values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(username));
            ps.setString(2, password);
            ps.setString(3, avatar);
            ps.setString(4, nickname);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps, null, con);
        }
    }

    public static boolean findByUsername(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sql = "select username from userinfo where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if(rs.next() && rs != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }
}
