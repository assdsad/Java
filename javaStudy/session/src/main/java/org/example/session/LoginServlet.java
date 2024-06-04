package org.example.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();//创建session   true没有会话会创建会话（不加参数就是true），false则不做处理

        session.setMaxInactiveInterval(5);//单位是秒  表示会话保存多长时间,超过这个时间自动销毁session

        session.setAttribute("un", username);
        session.setAttribute("password", password);

        response.sendRedirect("center");//重定向
    }
}
