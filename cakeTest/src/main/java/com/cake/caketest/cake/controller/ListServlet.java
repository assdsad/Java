package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.CakeService;
import com.cake.caketest.db.Db;
import com.cake.caketest.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

//该servlet用来查找蛋糕，要想显示蛋糕信息要再用一个servlet
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、

        //2、完成业务
        CakeService cakeService = new CakeService();
        List<Cake> cakes = cakeService.listAll();//把蛋糕数据存入cakes中

        //3、跳转到显示蛋糕信息的servlet
        request.setAttribute("cakes", cakes);//把蛋糕信息和"cakes"字符串链接起来
            //跳转(转发请求)
        request.getRequestDispatcher("show").forward(request, response);
////        this.getServletContext().setAttribute("cakes", cakes);//作用域太大


//        //学session之后的代码,直接得到10个蛋糕
//        Db.cakeArrayList.clear();
//        for(int i = 0 ; i < 10 ; i++) {
//            Cake cake = new Cake();
//            cake.setId(i + 1);
//            cake.setName("蛋糕" + i);
//            cake.setPrice(i * 100);
//            cake.setDescription("123");
//            Db.cakeArrayList.add(cake);
//        }
//        request.setAttribute("cakes", Db.cakeArrayList);//把蛋糕信息和"cakes"字符串链接起来
//
//        request.getRequestDispatcher("show").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
