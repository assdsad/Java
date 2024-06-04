package org.example.databasetest.user.dao;

import org.example.databasetest.utils.DbUtils;

import java.sql.*;

public class UserDao {
    public void findAll(){
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            con = DbUtils.getCon();

            String sql = "select * from tb_user";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                String email = rs.getNString(1);
                String name = rs.getString(2);
                Date date = rs.getDate(3);
                System.out.println(email + "  " + name + "  " + date.toLocaleString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.close(rs, ps, con);
        }

    }

    public boolean findByEmailAndName(String email, String name) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        //加载驱动
        //在DbUtil中的静态代码块中

        try {
            con = DbUtils.getCon();

            String sql = "select * from tb_user where email = ? and name = ?";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, name);
            rs = ps.executeQuery();
            if(rs != null && rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DbUtils.close(rs, ps, con);
        }
    }


}
