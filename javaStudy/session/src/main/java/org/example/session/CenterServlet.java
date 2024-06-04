package org.example.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/center")
public class CenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("un");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("欢迎登录" + session.getAttribute("un"));
        out.println("密码为" + session.getAttribute("password"));

        out.println("<a href='logoff'>注销</a>");//退出
        out.println("</body></html>");

        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
