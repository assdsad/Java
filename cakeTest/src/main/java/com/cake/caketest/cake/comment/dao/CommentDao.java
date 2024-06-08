package com.cake.caketest.cake.comment.dao;

import com.cake.caketest.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class CommentDao {
    public void saveComment(String content, String email, String id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false);
            ps = con.prepareStatement("insert into tbl_comment values(?,?,?,?)");
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, new Date().toLocaleString());
            ps.setString(3, email);
            ps.setString(4, content);
            ps.executeUpdate();

//            int a = 10 / 0;//添加了事务
            ps = con.prepareStatement("update tbl_comment set comment = 'manba out' where cakeid = ?");
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            DbUtil.close(null, ps, con);
        }
    }
}
