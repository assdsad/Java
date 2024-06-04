package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.CakeService;
import com.cake.caketest.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/add")
public class AddCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求
        String name = request.getParameter("cakeName");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        System.out.println(name);
        //1、1验证数据

        //2、完成业务（处理请求） (调用service)
        Cake cake = new Cake();
        cake.setName(name);
        cake.setPrice(Integer.parseInt(price));
        cake.setDescription(description);
            //调用服务，把蛋糕信息加进去
        CakeService cakeService = new CakeService();
        cakeService.addCake(cake);

        //3、响应
        response.sendRedirect("addCake.html");//添加后跳转到添加页面继续添加
    }
}
