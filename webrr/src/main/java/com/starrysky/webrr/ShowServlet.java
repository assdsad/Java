package com.starrysky.webrr;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("show:" + name);

        Object obj = request.getAttribute("courseInfo");
        System.out.println("课程信息：" + obj);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
