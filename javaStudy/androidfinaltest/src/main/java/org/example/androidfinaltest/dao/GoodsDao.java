package org.example.androidfinaltest.dao;

import org.example.androidfinaltest.entity.GoodsInfo;
import org.example.androidfinaltest.entity.OrderFormInfo;
import org.example.androidfinaltest.entity.SelectedGoods;
import org.example.androidfinaltest.util.DBUtil;
import org.example.androidfinaltest.util.ResultUtil;

import java.awt.image.DataBufferInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class GoodsDao {

    public static List<SelectedGoods> getCartDBbyUsername(String username) {
        List<SelectedGoods> cartList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sql = "select * from cartinfo where username = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(username));
            rs = ps.executeQuery();
            while(rs.next()) {
                SelectedGoods good = new SelectedGoods();
                good.setUsername(username);
                good.setId(rs.getInt("id"));
                good.setImage(rs.getString("image"));
                good.setName(rs.getString("name"));
                good.setPrice(String.valueOf(rs.getInt("price")));
                good.setCount(rs.getInt("count"));
                good.setInventory(rs.getInt("inventory"));
                cartList.add(good);
            }

            return cartList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }
    public static void updateCartDBbyUsername(String username, List<SelectedGoods> cartList) {
        //先删除该用户在表中的购物车信息，再把新的购物车信息插入
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sqlDelete = "delete from cartinfo where username = ?";
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, Integer.parseInt(username));
            ps.executeUpdate();

            String sqlUpdate = "insert into cartinfo (id, image, name, price, count, username, inventory) values(?, ?, ?, ?, ?, ?, ?)";
            for(SelectedGoods good : cartList) {
                ps = con.prepareStatement(sqlUpdate);
                ps.setInt(1, good.getId());
                ps.setString(2, good.getImage());
                ps.setString(3, good.getName());
                ps.setInt(4, Integer.parseInt(good.getPrice()));
                ps.setInt(5, good.getCount());
                ps.setInt(6, Integer.parseInt(good.getUsername()));
                ps.setInt(7, good.getInventory());
                ps.executeUpdate();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps, null, con);
        }

    }

    public static TreeMap<String, List<OrderFormInfo>> findVariesOrderFormByUsername(int username) {
        TreeMap<String, List<OrderFormInfo>> map = new TreeMap<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sql = "select * from orderform where username = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, username);
            rs = ps.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                int count = rs.getInt("count");
                Timestamp timestamp = rs.getTimestamp("time");

                String time = sdf.format(timestamp);
                //如果map中没有这个键，则创建一个新的列表
                map.putIfAbsent(time, new ArrayList<>());

                OrderFormInfo orderFormInfo = new OrderFormInfo(id, name, price, image, count, time, username);

                map.get(time).add(orderFormInfo);

            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(ps , rs, con);
        }
    }


    public static void addOrderFormData(SelectedGoods good) {//从详情页面购买
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "insert into orderform (id, name, price, image, count, username, time) values(?, ?, ?, ?, ?, ?, now())";
            ps = con.prepareStatement(sql);
            ps.setInt(1, good.getId());
            ps.setString(2, good.getName());
            ps.setInt(3, Integer.parseInt(good.getPrice()));
            ps.setString(4, good.getImage());
            ps.setInt(5, good.getCount());
            ps.setInt(6, Integer.parseInt(good.getUsername()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps , null, con);
        }
    }
    public static void addOrderFormData(List<SelectedGoods> goodsList) {//从购物车购买
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "insert into orderform (id, name, price, image, count, username, time) values(?, ?, ?, ?, ?, ?, now())";
            for(SelectedGoods good : goodsList) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, good.getId());
                ps.setString(2, good.getName());
                ps.setInt(3, Integer.parseInt(good.getPrice()));
                ps.setString(4, good.getImage());
                ps.setInt(5, good.getCount());
                ps.setInt(6, Integer.parseInt(good.getUsername()));
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps, null, con);
        }
    }

    public static void subVariesInventory(List<SelectedGoods> goodsList) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
         try {
             con = DBUtil.getCon();
             for(SelectedGoods good : goodsList) {
                 String sql = "update cakeinfo set inventory = inventory - ? where id = ?";
                 ps = con.prepareStatement(sql);
                 ps.setInt(1, good.getCount());
                 ps.setInt(2, good.getId());
                 ps.executeUpdate();
             }
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             DBUtil.close(ps, rs, con);
         }
    }

    public static void subInventory(int id, int count) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sql = "update cakeinfo set inventory = inventory - ? where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, count);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }
    public static int findInventory(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            con = DBUtil.getCon();
            String sql = "select inventory from cakeinfo where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next() && rs != null) {
                int count = rs.getInt(1);
                return count;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }

    //找到数据库中所有商品的信息
    public static List<GoodsInfo> findAll() {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            String sql = "select * from cakeinfo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                GoodsInfo good = new GoodsInfo();
                good.setId(rs.getInt("id"));
                good.setName(rs.getString("name"));
                good.setPrice(rs.getInt("price"));
                good.setCount(rs.getInt("inventory"));
                good.setImg(rs.getString("img"));
                good.setDescription(rs.getString("description"));
                goodsInfoList.add(good);
            }
            return goodsInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(ps, rs, con);
        }
    }
}
