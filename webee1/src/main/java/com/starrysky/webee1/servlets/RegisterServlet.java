package com.starrysky.webee1.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取请求
        String username = request.getParameter("username");//获取值
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        String home = request.getParameter("home");
        String[] hobbies = request.getParameterValues("hobby");//获取复选框中的值

        //2、完成业务
        System.out.println(username);
        System.out.println(pwd);
        System.out.println(gender);
        System.out.println(home);
        for(String hobby : hobbies){
            System.out.print(hobby + "  ");
        }

//        3、响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("注册成功");//输出流，往客户端发送
        response.getWriter().write("<html><body><h3>注册成功</h3></body></html>");
    }
}
