package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.CakeService;
import com.cake.caketest.db.Db;
import com.cake.caketest.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit")
public class EditCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cake cake1 = null;
        for(Cake cake : Db.cakeArrayList) {
            if (cake.getId() == Integer.parseInt(id)) {
                cake1 = cake;
                break;
            }
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action='edit' method='post'>");//点击修改后还是在editservlet中处理修改后的数据
        out.println("<input type='hidden' name='id' value='" + cake1.getId() + "'/>");
        out.println("<input type='text' name='name' value='" + cake1.getName() + "'/></br>");
        out.println("<input type='text' name='price' value='" + cake1.getPrice() + "'/></br>");
        out.println("<textarea name='description' value='" + cake1.getDescription() + "' rows='5' cols='100'></textarea>");
        out.println("<input type='submit' value='修改'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        CakeService cakeService = new CakeService();

        //根据id修改
        cakeService.editCake(Integer.parseInt(id), name, Integer.parseInt(price), description);
        //下方代码也可代替
//        for(Cake cake : Db.cakeArrayList) {
//            if (cake.getId() == Integer.parseInt(id)) {
//                cake.setName(name);
//                cake.setPrice(Integer.parseInt(price));
//                cake.setDescription(description);
//            }
//        }

        response.sendRedirect("list");
    }
}
