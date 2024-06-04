package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.CakeService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editProcess")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

//        System.out.println("cakecake");
        String id = request.getParameter("editId");
//        System.out.println(id);
        CakeService cakeService = new CakeService();

        String name = request.getParameter("editName");
        String price = request.getParameter("editPrice");
//        System.out.println(price + "              " + name);
        cakeService.editCake(Integer.parseInt(id), name, Integer.parseInt(price));

        response.sendRedirect("list");//修改后重新进行查询，重新进行显示



//        String name = request.getParameter("editName");
//        String price = request.getParameter("editPrice");
//        CakeService cakeService = new CakeService();
//
//        Cake cake = (Cake) request.getAttribute("editCake");
//        cakeService.editCake(cake.getId(), name, Integer.parseInt(price));
//
////        response.sendRedirect("list");
//
//        System.out.println(name);
    }
}
