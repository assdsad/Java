package com.cake.caketest.cake.service;

import com.cake.caketest.entity.Cake;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer, CartItem> map = new HashMap<>();
    //              蛋糕id     哪个蛋糕买了几个
    public void addCake(Cake cake) {
        if(map.containsKey(cake.getId())) {//说明有这个蛋糕的信息，购买的数量直接加1就行
            CartItem cartItem = map.get(cake.getId());
            cartItem.setCount(cartItem.getCount() + 1);
            map.put(cake.getId(), cartItem);
        }else {//新增这个蛋糕
            CartItem cartItem = new CartItem();
            cartItem.setCake(cake);
            cartItem.setCount(1);
            map.put(cake.getId(), cartItem);
        }
    }

    public HashMap<Integer, CartItem> getMap(){
        return map;
    }
}
