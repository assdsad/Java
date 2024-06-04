package com.cake.caketest.cake.service;

import com.cake.caketest.cake.dao.CakeDao;
import com.cake.caketest.db.Db;
import com.cake.caketest.entity.Cake;

import java.util.List;

public class CakeService {
    public void addCake(Cake cake) {
        //调用dao，把数据存入数据库
        new CakeDao().saveCake(cake);
    }

    //查蛋糕
    public List<Cake> listAll() {
        return new CakeDao().findAll();
    }

    //根据id来查找蛋糕
    public Cake findCakeById(int id){
        return new CakeDao().findById(id);
    }

    public void deleteCake(int id){
        new CakeDao().delete(id);
    }

    //根据蛋糕的id来修改蛋糕
    public void editCake(int id, String name, int price){
        new CakeDao().edit(id, name, price);
    }

    public void editCake(int id, String name, int price, String description){
        new CakeDao().edit(id, name, price, description);
    }

}
