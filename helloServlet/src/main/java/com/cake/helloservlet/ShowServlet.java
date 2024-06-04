package com.cake.helloservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //打印前一个Servlet被访问了多少次
        Object obj = this.getServletContext().getAttribute("count");
        if(obj == null){
            response.getWriter().print("<html><body><h1>0</h1></body></html>");
        }else{
            response.getWriter().print("<html><body><h1>" + obj + "</h1></body></html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
