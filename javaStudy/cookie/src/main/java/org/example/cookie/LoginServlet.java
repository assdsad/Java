package org.example.cookie;

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

        if (username.equals("zhangsan") && password.equals("123456")) {
            Cookie cookie = new Cookie("un", username);//给cookie取名为un
            cookie.setMaxAge(-1);//设置最大存活时长，秒  -1表示cookie只适用于当前的浏览会话   0表示删除cookie
//            cookie.setDomain("/");//设置域
            response.addCookie(cookie);//给客户端发送cookie
            response.sendRedirect("main.jsp");
        }else {
            response.sendRedirect("index.jsp");
        }
    }
}
