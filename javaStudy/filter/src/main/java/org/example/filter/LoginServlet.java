package org.example.filter;

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
        String pwd = request.getParameter("pwd");

        if("zhangsan".equals(username) && "123".equals(pwd)) {
            request.getSession().setAttribute("un", username);
            response.sendRedirect("cake/add.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
