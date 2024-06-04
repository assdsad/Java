package org.example.avatartest.servlet;

import cn.hutool.crypto.digest.MD5;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.avatartest.Dao.UserDao;
import org.example.avatartest.entity.Userinfo;
import org.example.avatartest.utils.DBUtils;
import org.example.avatartest.utils.ReadWriteUserInfoUtil;
import org.example.avatartest.utils.ResultUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取到注册页面传输过来的用户名和密码
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();//输出流，往回写的输出流
        if("".equals(phone) || phone == null) {//用户名为空
            out.write(ResultUtils.error("用户名不能为空"));
        } else if("".equals(password) || password == null) {
            out.write(ResultUtils.error("密码不能为空"));
        } else {
            //在数据库中判断用户名是否已经注册过
            if(UserDao.findByPhone(phone) == true) {//用户名已注册
                out.write(ResultUtils.phoneExist("用户名已存在，请重新输入"));
                return;
            } else {
                String hex16 = MD5.create().digestHex16(password);
                //将信息返回给安卓端时   以对象的形式返回
                Userinfo userinfo = new Userinfo();
                userinfo.setPhone(phone);
                userinfo.setPassword(hex16);

                UserDao.insertIntoDB(phone, hex16, "");
                out.write(ResultUtils.success("注册成功", userinfo));
                out.close();

            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
