package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.CakeService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1

        String id = request.getParameter("id");//<a href='delete?id=" + cake.getId() + "'>这里的id

        //2
        CakeService cakeService = new CakeService();
        cakeService.deleteCake(Integer.parseInt(id));

        //跳转
        response.sendRedirect("list");//重新进行查询，重新进行展示

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
