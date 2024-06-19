package org.example.androidfinaltest.servlet;

import cn.hutool.crypto.digest.MD5;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.androidfinaltest.dao.UserDao;
import org.example.androidfinaltest.entity.UserInfo;
import org.example.androidfinaltest.util.ResultUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取安卓端发送过来的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        if("".equals(username) || username == null) {
            out.write(ResultUtil.error("用户名不能为空"));
        } else if("".equals(password) || password == null) {
            out.write(ResultUtil.error("密码不能为空"));
        } else {
            //在数据库中找  用户名是否已经存在
            //如果用户名已存在
            if(UserDao.findByUsername(username) == true) {
                out.write(ResultUtil.usernameExist("用户名已存在"));
                return;
            } else {
                //给密码加密
                String hex16 = MD5.create().digestHex16(password);
                //返回给安卓端   以对象形式返回
                UserInfo userInfo = new UserInfo();
                userInfo.setUsername(username);
                userInfo.setPassword(hex16);

                                                                //默认头像                                                                 默认昵称
                UserDao.insertIntoDB(username, hex16, "https://pic2.zhimg.com/v2-4ad61f2b08f6597e8fe52c85c5fc1459_r.jpg", username + "abc");
                out.write(ResultUtil.success("注册成功", userInfo));
            }
        }
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
