package org.example.avatartest.servlet;

import cn.hutool.crypto.digest.MD5;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.avatartest.Dao.UserDao;
import org.example.avatartest.entity.Userinfo;
import org.example.avatartest.utils.ReadWriteUserInfoUtil;
import org.example.avatartest.utils.ResultUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/json;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        //获取安卓端发送过来的用户名和密码
//        String phone = request.getParameter("phone");
//        String password = request.getParameter("password");
//
//        PrintWriter out = response.getWriter();
//        //判断用户名或密码是否为空
//        if("".equals(phone) || phone == null) {
//            out.write(ResultUtils.error("用户名不能为空"));
//            return;
//        }
//        if("".equals(password) || password == null) {
//            out.write(ResultUtils.error("密码不能为空"));
//            return;
//        }
//
//        //用户名和密码都不为空时， 判断用户名和密码是否正确
//        //先获取所有用户的信息
//        List<Userinfo> userinfoList = ReadWriteUserInfoUtil.queryUserinfo();
//        //存储的是加密后的密码，所以先加密后比较
//        String hex16 = MD5.create().digestHex16(password);
//        for(Userinfo userinfo : userinfoList) {
//            if(userinfo.getPhone().equals(phone) && userinfo.getPassword().equals(hex16)) {
//                out.print(ResultUtils.success("登录成功", userinfo));
//                return;
//            }
//        }
//
//        //用户名或密码错误
//        out.write(ResultUtils.error("用户名或密码错误"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取安卓端发送过来的用户名和密码
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        //判断用户名或密码是否为空
        if("".equals(phone) || phone == null) {
            out.write(ResultUtils.error("用户名不能为空"));
            return;
        }
        if("".equals(password) || password == null) {
            out.write(ResultUtils.error("密码不能为空"));
            return;
        }

        String hex16 = MD5.create().digestHex16(password);
        if(UserDao.findByPhoneAndPassword(phone, hex16)) {//找到了对应的phone和password
            Userinfo userinfo = new Userinfo();
            userinfo.setPhone(phone);
            userinfo.setPassword(password);
            userinfo.setAvatar("");
            out.print(ResultUtils.success("登录成功", userinfo));
            return;
        }

        //用户名和密码都不为空时， 判断用户名和密码是否正确
        //先获取所有用户的信息
//        List<Userinfo> userinfoList = ReadWriteUserInfoUtil.queryUserinfo();
//        //存储的是加密后的密码，所以先加密后比较
//        String hex16 = MD5.create().digestHex16(password);
//        for(Userinfo userinfo : userinfoList) {
//            if(userinfo.getPhone().equals(phone) && userinfo.getPassword().equals(hex16)) {
//                out.print(ResultUtils.success("登录成功", userinfo));
//                return;
//            }
//        }

        //用户名或密码错误
        out.write(ResultUtils.error("用户名或密码错误"));
    }
}
