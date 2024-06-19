package org.example.androidfinaltest.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class UserInfo {
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private List<GoodsInfo> goodsInfoList;
    private List<SelectedGoods> cartList;
    private TreeMap<String, List<OrderFormInfo>> orderFormMap;

    public List<SelectedGoods> getCartList() {
        return cartList;
    }

    public void setCartList(List<SelectedGoods> cartList) {
        this.cartList = cartList;
    }

    public TreeMap<String, List<OrderFormInfo>> getOrderFormMap() {
        return orderFormMap;
    }

    public void setOrderFormMap(TreeMap<String, List<OrderFormInfo>> orderFormMap) {
        this.orderFormMap = orderFormMap;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }
    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}