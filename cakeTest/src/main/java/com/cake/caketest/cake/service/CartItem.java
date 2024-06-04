package com.cake.caketest.cake.service;

import com.cake.caketest.entity.Cake;

public class CartItem {
    private Cake cake;
    private int count;//买了几个蛋糕

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
