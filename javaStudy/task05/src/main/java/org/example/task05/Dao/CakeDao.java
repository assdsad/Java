package org.example.task05.Dao;

import org.example.task05.entity.Cake;
import org.example.task05.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CakeDao {
    public void updateState(int id, int state) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        String sql = "update tbl_cake set state = ? where id = ?";
        con = DbUtil.getCon();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, state);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(con, ps, rs);
        }

    }

    //查询所有在售蛋糕
    public List<Cake> findByNormalState() {
        List<Cake> cakes = new ArrayList<>();
        Statement sm = null;
        ResultSet rs = null;
        Connection con = null;

        String sql = "select id, name, price from tbl_cake where state = 1";

        con = DbUtil.getCon();
        try {
            sm = con.createStatement();
            rs = sm.executeQuery(sql);
            while(rs.next()) {
                Cake cake = new Cake();
                cake.setId(rs.getInt(1));
                cake.setName(rs.getString(2));
                cake.setPrice(rs.getInt(3));
                cakes.add(cake);
            }

            return cakes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DbUtil.close(con, sm, rs);
        }

    }

    public void saveCake(Cake cake) {
        Statement sm = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection con = null;
        String sql = "select count(*) from tbl_cake";//获取表中蛋糕种类个数
        try {
            con = DbUtil.getCon();
            sm = con.createStatement();
            rs = sm.executeQuery(sql);
            if(rs.next()) {
                int count = rs.getInt(1);//得到蛋糕种类个数
                String sql1 = "insert into tbl_cake(id, name, price, state) values(?,?,?,?)";
                ps = con.prepareStatement(sql1);
                ps.setInt(1,count + 1);
                ps.setString(2, cake.getName());
                ps.setInt(3, cake.getPrice());
                ps.setInt(4, cake.getState());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(con, ps, rs);
            try {
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
