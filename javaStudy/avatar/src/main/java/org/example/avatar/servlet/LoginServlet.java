package org.example.avatar.servlet;

import cn.hutool.crypto.digest.MD5;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.avatar.entity.RegisteredInfo;
import org.example.avatar.entity.UserInfo;
import org.example.avatar.utils.ReadWriteUserInfoUtil;
import org.example.avatar.utils.ResultUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        String phone = request.getParameter("phone");
//        String password = request.getParameter("password");
//
//        PrintWriter os = response.getWriter();//往回写的输出流
//        if("".equals(phone) || phone == null) {
//            os.write(ResultUtils.loginError("用户名不能为空"));
//        } else if ("".equals(password) || password == null) {
//            os.write(ResultUtils.loginError("密码不能为空"));
//        } else {
//            BufferedReader br = null;
//            try {
//                //获取文件中已经注册用户的数据
//                br = new BufferedReader(new FileReader("G:/user_info/db/user-info.txt"));
//                String line;
//                while((line = br.readLine()) != null) {
//                    String[] arr = line.split(";");
//                    RegisteredInfo.userName.add(arr[0]);
//                    RegisteredInfo.pwd.add(arr[1]);
//                }
//                //判断用户是否存在
//                if(RegisteredInfo.userName.contains(phone)) {
//                    //如果用户存在，则判断密码是否正确
//                    String hex16 = MD5.create().digestHex16(password);//相同的密码加密后相同
//                    if(RegisteredInfo.pwd.contains(hex16)) {
//                        os.write(ResultUtils.loginSuccess("登录成功"));
//                    } else {//密码错误
//                        os.write(ResultUtils.loginError("密码错误"));
//                    }
//                } else {//用户名不存在
//                    os.write(ResultUtils.loginError("用户名不存在"));
//                }
//
//            }catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (br != null) {
//                    try{
//                        br.close();
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取安卓请求的参数phone
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        //判断是否为空
        PrintWriter out = response.getWriter();
        if(phone == null || "".equals(phone)) {
            out.write(ResultUtils.loginError("用户名不能为空"));
            return;
        }
        if(password == null || "".equals(password)) {
            out.write(ResultUtils.loginError("密码不能为空"));
            return;
        }

        //判断用户名和密码是否正确
        List<UserInfo> userInfoList = ReadWriteUserInfoUtil.queryUserInfo();
        for(UserInfo userInfo : userInfoList) {
            //先加密后比较
            String md5 = MD5.create().digestHex16(password);
            if(userInfo.getPhone().equals(phone) && userInfo.getPassword().equals(md5)) {
                out.print(ResultUtils.loginSuccess("登录成功", userInfo));
                return;
            }
        }
        out.print(ResultUtils.loginError("用户名或密码错误"));



    }
}
