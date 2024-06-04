package com.starrysky.webrr;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//加载类，实例化，初始化，服务，销毁

//@WebServlet("/login")//相当web.xml中的url
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

//        String name = request.getParameter("name");
////        String newString = new String(name.getBytes(), "UTF-8");
//        System.out.println(name);
////
//        PrintWriter out = response.getWriter();
////        out.println("<html><body>");
//        out.print("hello " + name);
//        out.flush();
//        out.close();

        request.setAttribute("courseInfo", "java");

        //重定向
//        response.sendRedirect("index2.html");//跳转到第二个servlet   第一个请求中的信息无法给第二个请求
//转发请求和重定向的区别    1、本质区别：重定向有两次请求，转发请求只有一个请求 2、

        //转发请求
//        RequestDispatcher dispatcher = request.getRequestDispatcher("show");
//        dispatcher.forward(request, response);
        request.getRequestDispatcher("show").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
