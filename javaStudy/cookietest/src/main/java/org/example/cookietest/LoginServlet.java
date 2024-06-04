package org.example.cookietest;

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
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if(userName.equals("zhangsan") && password.equals("123")) {
            Cookie cookie = new Cookie("un", userName);
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            response.sendRedirect("main.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
