package com.cake.caketest.cake.dao;

import com.cake.caketest.db.Db;
import com.cake.caketest.entity.Cake;

import java.util.List;

public class CakeDao {
    public void saveCake(Cake cake) {
        cake.setId(Db.cakeArrayList.size() + 1);//让id从1开始，并自增,,,有bug
        //用集合模拟数据库
        Db.cakeArrayList.add(cake);

        System.out.println(Db.cakeArrayList.size());
    }

    public List<Cake> findAll(){
        return Db.cakeArrayList;
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
