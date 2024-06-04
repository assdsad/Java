package com.cake.helloservlet;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("构造方法");
    }

    public void init() {
        System.out.println("init");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>hello world</h1>");
        out.println("</body></html>");

        ServletConfig servletConfig = this.getServletConfig();
        String url = servletConfig.getInitParameter("url");
        System.out.println(url);

        String Url = this.getServletContext().getInitParameter("url");
        System.out.println(Url);

    }

    public void destroy() {
        System.out.println("destory");
    }
}