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

@WebServlet(name = "updateUserinfo", value = "/updateUserinfo")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/json;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        String avatar = request.getParameter("update_avatar");
//        String nickname = request.getParameter("update_nickname");
//        String password = request.getParameter("update_password");
//        String username = request.getParameter("username");
//
//        PrintWriter out = response.getWriter();
//        if("".equals(avatar) || avatar == null) {
//            out.write(ResultUtil.error("头像地址不能为空"));
//            out.close();
//            return;
//        }
//        if("".equals(password) || password == null) {
//            out.write(ResultUtil.error("密码不能为空"));
//            out.close();
//            return;
//        }
//        if("".equals(nickname) || nickname == null) {
//            out.write(ResultUtil.error("昵称不能为空"));
//            out.close();
//            return;
//        }
//        String hex16 = MD5.create().digestHex16(password);
//        UserDao.updateUserinfoByUsername(username, hex16, nickname, avatar);
//
//        out.write(ResultUtil.success("修改成功", "修改成功"));
//        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String avatar = request.getParameter("update_avatar");
        String nickname = request.getParameter("update_nickname");
        String username = request.getParameter("username");

        PrintWriter out = response.getWriter();
        if("".equals(avatar) || avatar == null) {
            out.write(ResultUtil.error("头像地址不能为空"));
            out.close();
            return;
        }
        if("".equals(nickname) || nickname == null) {
            out.write(ResultUtil.error("昵称不能为空"));
            out.close();
            return;
        }
        UserDao.updateUserinfoByUsername(username, nickname, avatar);

        out.write(ResultUtil.success("修改成功", "修改成功"));
        out.close();
    }
}
