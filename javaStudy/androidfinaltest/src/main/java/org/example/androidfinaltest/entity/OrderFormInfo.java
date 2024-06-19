package org.example.androidfinaltest.entity;

import java.util.HashMap;
import java.util.List;

public class OrderFormInfo {
    private int id;
    private String name;
    private  int price;
    private String image;
    private int count;
    private String time;
    private int username;
    //同一用户，根据不同时间来区分不同订单
    public OrderFormInfo(){}

    public OrderFormInfo(int id, String name, int price, String image, int count, String time, int username) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.count = count;
        this.time = time;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }
}
