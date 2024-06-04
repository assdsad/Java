package org.example.avatar.utils;

import org.example.avatar.entity.UserInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteUserInfoUtil {
    private static final String path = "G:\\user_info\\db\\user-info.txt";//路径
    public static void saveUserInfo(UserInfo userInfo) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(path, true));
            String userInfoStr = String.format(
                    "%s;%s;%s",
                    userInfo.getPhone(),
                    userInfo.getPassword(),
                    userInfo.getAvatar()
            );
            bw.write(userInfoStr);
            bw.flush();
            bw.newLine();

        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //读文件并存入集合
    public static List<UserInfo> queryUserInfo() {
        List<UserInfo> userInfoList = new ArrayList<>();
        //读文件
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(path));
            String line = null;

            while((line = br.readLine()) != null) {
                //如果的到的字符串为空
                if("".equals(line)) {
                    continue;
                }
                //读到的字符串转换成对象
                String[] split = line.split(";");
                if(split.length != 3) {
                    continue;
                }
                UserInfo userInfo = new UserInfo();
                userInfo.setPhone(split[0]);
                userInfo.setPassword(split[1]);
                userInfo.setAvatar(split[2]);
                userInfoList.add(userInfo);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(br != null) {
                try{
                    br.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userInfoList;
    }
}
