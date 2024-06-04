package com.cake.helloservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

//通过ServletContext得到的数据，在整个Web程序中共享

public class CakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //count统计访问次数
        Object obj = this.getServletContext().getAttribute("count");
        //通过ServletContext得到的数据，在整个Web程序中公用
        if(obj == null){
            this.getServletContext().setAttribute("count" ,1);
        }else{
            int count = Integer.parseInt(obj.toString());
            count++;
            this.getServletContext().setAttribute("count", count);
//            this.getServletContext().removeAttribute("count");//删除
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
