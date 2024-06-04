package com.cake.work;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;


public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
////        String name = request.getParameter("name");
////        System.out.println(name);
        @SuppressWarnings("unchecked")
        Set<String> cakes = (Set<String>) request.getAttribute("cakeInfo");
        if(cakes != null){
            for(Object cake : cakes){
                System.out.println(cake);
            }
        } else{
            System.out.println("false");
        }
        for(Object cake : cakes){
            response.getWriter().print(cake);
        }
////        Object cakeInfo = request.getAttribute("cakeInfo");
////        System.out.println(cakeInfo);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //接收点击确定之后的信息
        @SuppressWarnings("unchecked")
        Set<String> cakes = (Set<String>) request.getAttribute("cakeInfo");
        if(cakes != null){
            for(Object cake : cakes){
                System.out.println(cake);
            }
        } else{
            System.out.println("false");
        }
        for(Object cake : cakes){
            response.getWriter().print(cake);
        }
        response.getWriter().print("<a href=\"#\">前去结算</a>");

    }
}
