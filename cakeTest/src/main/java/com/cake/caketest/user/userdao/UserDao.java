package com.cake.caketest.user.userdao;

import com.cake.caketest.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class UserDao {
    public void updateScore(String email, int score) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DbUtil.getCon();
            ps = con.prepareStatement("update tb_user set score = score + ? where email = ?");
            ps.setInt(1, score);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(null, ps, con);
        }
    }
}
