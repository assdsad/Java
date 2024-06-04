package org.example.chat;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //登录页面

        //获取请求
        String username = request.getParameter("username");

        //处理业务
        //用linkedhashset存储用户的名字
        Object objNames = this.getServletContext().getAttribute("names");
        if(objNames == null) {//第一次登录时
            LinkedHashSet<String> names = new LinkedHashSet<>();
            names.add(username);
            this.getServletContext().setAttribute("names", names);
            request.getSession().setAttribute("myself", username);//用来记录当前用户

            response.sendRedirect("main.html");//登录成功后跳转到主页面,重定向
        }else {//不是第一次登录
            LinkedHashSet<String> names = (LinkedHashSet<String>) objNames;
            //判断输入的名字是否用过
            if(names.contains(username)) {//如果这个名字之前用过则跳转到初始页面
                request.setAttribute("errorInfo", "<font color='red'>账号已被使用！请换一个</font>");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {//之前没用过
                names.add(username);
                request.getSession().setAttribute("myself", username);
                response.sendRedirect("main.html");
            }
        }
    }
}
