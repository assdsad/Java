package com.cake.caketest.db;

import com.cake.caketest.entity.Cake;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Db {
    public static CopyOnWriteArrayList<Cake> cakeArrayList = new CopyOnWriteArrayList<>();
}
