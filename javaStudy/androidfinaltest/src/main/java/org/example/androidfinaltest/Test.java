package org.example.androidfinaltest;

import org.example.androidfinaltest.dao.GoodsDao;
import org.example.androidfinaltest.entity.OrderFormInfo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeMap<String , List<OrderFormInfo>> map = GoodsDao.findVariesOrderFormByUsername(123123);
        for(Map.Entry<String, List<OrderFormInfo>> entry : map.entrySet()) {
            String time = entry.getKey();
            List<OrderFormInfo> orderFormInfos = entry.getValue();
            System.out.println("time : " + time);

            for(OrderFormInfo orderFormInfo : orderFormInfos) {
                System.out.println(orderFormInfo.getName() + "图片："+ orderFormInfo.getImage());
            }
        }

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(now);
        System.out.println(time);
    }
}
