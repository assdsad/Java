package org.example.avatar.servlet;

import cn.hutool.crypto.digest.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.avatar.entity.RegisteredInfo;
import org.example.avatar.entity.UserInfo;
import org.example.avatar.utils.ReadWriteUserInfoUtil;
import org.example.avatar.utils.ResultUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        //获取注册页面的用户名和密码
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        PrintWriter os = response.getWriter();//往回写的输出流
        if(phone == null || "".equals(phone)) {

            //两部分代码相同，提出来到ResultUtils类中
//            //前后端交互数据，传输数据是文本数据， 流数据   文本形式：XML   JSON("":"")
//            Result result = new Result();
//            result.setCode(500);//服务器返回异常
//            result.setMessage("手机号不能为空");
//            //把result对象 转成 JSON
//            String jsonStr = JSONUtil.toJsonStr(result);
//            os.write(jsonStr);//以流的形式传给android端

            os.write(ResultUtils.registerError("用户名不能为空"));//code都为500，可以再次提炼
        } else if(password == null || "".equals(password)) {
//            //前后端交互数据，传输数据是文本数据， 流数据   文本形式：XML   JSON("":"")
//            Result result = new Result();
//            result.setCode(500);//服务器返回异常
//            result.setMessage("密码不能为空");
//            //把result对象 转成 JSON
//            String jsonStr = JSONUtil.toJsonStr(result);
//            os.write(jsonStr);//以流的形式传给android端

            os.write(ResultUtils.registerError("密码不能为空"));
        } else {
            //TODO  判断用户名是否存在
            BufferedReader br = null;
            try{
                //获取文件中已经注册用户的数据
                br = new BufferedReader(new FileReader("G:/user_info/db/user-info.txt"));
                String line;
                while((line = br.readLine()) != null) {
                    String[] arr = line.split(";");
                    RegisteredInfo.userName.add(arr[0]);
                    RegisteredInfo.pwd.add(arr[1]);
//                    RegisteredInfo.avatarMap.put(phone, 123);//存储头像
                }

                if(RegisteredInfo.userName.contains(phone)) {
                    os.write(ResultUtils.exist("用户名已被注册，请换一个"));
                } else {
                    //用户名不存在时再进行注册
                    //加密密码
                    String hex16 = MD5.create().digestHex16(password);

                    //将信息返回给Android端,,,,以对象的形式
                    UserInfo userInfo = new UserInfo();
                    userInfo.setPhone(phone);
                    userInfo.setPassword(hex16);//加密后的密码
//            userInfo.setAvatar();

                    //把userInfo写到文件中     可以换成数据库
                    ReadWriteUserInfoUtil.saveUserInfo(userInfo);
                    os.write(ResultUtils.registerSuccess("注册成功", userInfo));
                }
            }catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    br.close();
                }
            }

//            //加密密码
//            String hex16 = MD5.create().digestHex16(password);
//
//            //将信息返回给Android端,,,,以对象的形式
//            UserInfo userInfo = new UserInfo();
//            userInfo.setPhone(phone);
//            userInfo.setPassword(hex16);//加密后的密码
////            userInfo.setAvatar();
//
//            //把userInfo写到文件中     可以换成数据库
//            ReadWriteUserInfoUtil.saveUserInfo(userInfo);
//            os.write(ResultUtils.success("注册成功", userInfo));
        }
    }
}
