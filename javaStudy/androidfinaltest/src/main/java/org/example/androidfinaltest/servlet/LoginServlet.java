package org.example.androidfinaltest.servlet;

import cn.hutool.crypto.digest.MD5;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.androidfinaltest.dao.GoodsDao;
import org.example.androidfinaltest.dao.UserDao;
import org.example.androidfinaltest.entity.UserInfo;
import org.example.androidfinaltest.util.DBUtil;
import org.example.androidfinaltest.util.ResultUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/json;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        PrintWriter out = response.getWriter();
//        if("".equals(username) || username == null) {
//            out.write(ResultUtil.error("用户名不能为空"));
//            out.close();
//            return;
//        }
//        if("".equals(password) || password == null) {
//            out.write(ResultUtil.error("密码不能为空"));
//            out.close();
//            return;
//        }
//        String hex16 = MD5.create().digestHex16(password);
//        if(UserDao.findByUsernameAndPassword(username, hex16) == true) {
//            UserInfo userInfo = new UserInfo();
//            userInfo.setUsername(username);
//            userInfo.setPassword(password);
//            userInfo.setAvatar("");
//            out.write(ResultUtil.success("登录成功", userInfo));
//            out.close();
//            return;
//        }
//        out.write(ResultUtil.error("用户名或密码错误"));
//        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        if("".equals(username) || username == null) {
            out.write(ResultUtil.error("用户名不能为空"));
            out.close();
            return;
        }
        if("".equals(password) || password == null) {
            out.write(ResultUtil.error("密码不能为空"));
            out.close();
            return;
        }
        String hex16 = MD5.create().digestHex16(password);
        if(UserDao.findByUsernameAndPassword(username, hex16) == true) {
            //在数据库中找到对应的用户名和密码后， 将username，hex16和所有从数据库中读出的商品的信息保存到userInfo中传给安卓端
            UserInfo userInfo = new UserInfo();
            //登录时获取该用户的订单信息
            userInfo.setOrderFormMap(GoodsDao.findVariesOrderFormByUsername(Integer.parseInt(username)));
            //登录时获取数据库中所有的商品
            userInfo.setGoodsInfoList(GoodsDao.findAll());
            userInfo.setCartList(GoodsDao.getCartDBbyUsername(username));
            userInfo.setUsername(username);
            userInfo.setPassword(hex16);
            userInfo.setAvatar(UserDao.getAvatar(username));
            userInfo.setNickname(UserDao.getNickname(username));
            out.write(ResultUtil.success("登录成功", userInfo));
            out.close();
            return;
        }
        out.write(ResultUtil.error("用户名或密码错误"));
        out.close();

    }
}
