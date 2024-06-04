package org.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.LinkedHashSet;

@WebServlet("/login")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求
        String username = request.getParameter("username");
        //业务处理
        Object objNames = this.getServletContext().getAttribute("names");
        if(objNames == null) {
            LinkedHashSet<String> names = new LinkedHashSet<>();
            names.add(username);
            this.getServletContext().setAttribute("names", names);
            request.getSession().setAttribute("myself", username);

            response.sendRedirect("main.html");
        } else {//已经有了主界面
            LinkedHashSet<String> names = (LinkedHashSet<String>) objNames;
            if(names.contains(username)){//这个名字已经被用过，跳转到登录页面
                request.setAttribute("errorInfo", "<font color='red'>您的账号已存在，请换一个！</font>");
                request.getRequestDispatcher("index.jsp").forward(request, response);//转发请求
            } else {
                names.add(username);
                request.getSession().setAttribute("myself", username);
                response.sendRedirect("main.html");
            }
        }
    }
}
