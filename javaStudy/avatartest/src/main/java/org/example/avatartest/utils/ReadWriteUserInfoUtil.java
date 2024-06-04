package org.example.avatartest.utils;

import org.example.avatartest.entity.Userinfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteUserInfoUtil {
    private static final String path = "G:/user_info/db_test/user-info.txt";

    public static void updateUserinfo(String phone, String avatar) {
        //先得到所有用户信息
        List<Userinfo> userinfoList = queryUserinfo();
        emptyUserinfo();//清除所有用户信息
        for(Userinfo userinfo : userinfoList) {
            //更新用户信息
            if(userinfo.getPhone().equals(phone)) {
                userinfo.setAvatar(avatar);
            }
            //将所有用户信息写回到文本文件中
            saveUserinfo(userinfo);
        }
    }
    public static void saveUserinfo(Userinfo userinfo) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(path, true));//写入一行之后换行
            String userInfoStr = String.format(
                    "%s;%s;%s",
                    userinfo.getPhone(),
                    userinfo.getPassword(),
                    userinfo.getAvatar()
            );
            bw.write(userInfoStr);//将用户数据写入
            bw.flush();
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取用户信息
    public static List<Userinfo> queryUserinfo(){
        List<Userinfo> userinfoList = new ArrayList<>();
        //读文件
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(path));
            String line = null;

            while((line = br.readLine()) != null) {
                if("".equals(line)) {//如果这一行是空的，则跳过
                    continue;
                }
                String[] split = line.split(";");//把用户名， 密码， 头像分隔开
                if(split.length != 3) {//例如一行有两个用户的信息
                    continue;
                }

                Userinfo userinfo = new Userinfo();
                userinfo.setPhone(split[0]);
                userinfo.setPassword(split[1]);
                userinfo.setAvatar(split[2]);
                userinfoList.add(userinfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userinfoList;
    }

    public static void emptyUserinfo() {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write("");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
