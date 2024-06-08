package com.cake.caketest.cake.dao;

import com.cake.caketest.db.Db;
import com.cake.caketest.entity.Cake;
import com.cake.caketest.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CakeDao {
    public void saveCake(Cake cake) {
        cake.setId(Db.cakeArrayList.size() + 1);//让id从1开始，并自增,,,有bug
        //用集合模拟数据库
        Db.cakeArrayList.add(cake);

        System.out.println(Db.cakeArrayList.size());
    }

    public List<Cake> findAll(){
        List<Cake> cakes = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getCon();

            String sql = "select * from tbl_cake";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Cake cake = new Cake();
                cake.setId(rs.getInt("id"));
                cake.setName(rs.getString("name"));
                cake.setPrice(rs.getInt("price"));
                cake.setDescription(rs.getString("description"));
                cakes.add(cake);
            }
            return cakes;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            DbUtil.close(rs, ps, con);
        }

//        return Db.cakeArrayList;
    }
    public Cake findById(int id){
        return Db.cakeArrayList.get(id - 1);
    }

    public void delete(int id){
        for(Cake cake : Db.cakeArrayList){
            if(id == cake.getId()) {
                Db.cakeArrayList.remove(cake);
            }
        }
    }

    public void edit(int id, String name, int price){
        Db.cakeArrayList.get(id - 1).setName(name);
        Db.cakeArrayList.get(id - 1).setPrice(price);
    }

    public void edit(int id, String name, int price, String description){
        Db.cakeArrayList.get(id - 1).setName(name);
        Db.cakeArrayList.get(id - 1).setPrice(price);
        Db.cakeArrayList.get(id - 1).setDescription(description);
    }

}
