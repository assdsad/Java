package com.cake.helloservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CakeServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = this.getServletContext().getAttribute("count");
        if(obj == null){
            this.getServletContext().setAttribute("count" ,1);
        }else{
            int count = Integer.parseInt(obj.toString());
            count++;
            this.getServletContext().setAttribute("count", count);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
