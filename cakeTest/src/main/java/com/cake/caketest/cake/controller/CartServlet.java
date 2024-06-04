package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.Cart;
import com.cake.caketest.db.Db;
import com.cake.caketest.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/buy")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");//购买蛋糕的id
        Cake cake = null;
        for(Cake c : Db.cakeArrayList) {
            if(c.getId() == Integer.parseInt(id)) {
                cake = c;//取出需要的蛋糕
            }
        }

        HttpSession session = request.getSession();
        //先判断是否有购物车
        Object obj = session.getAttribute("cart");
        Cart cart = null;
        if(obj == null) {
            cart = new Cart();
        } else {
            cart = (Cart)obj;
        }
        //添加到购物车
//        Cart cart = new Cart();//每次点击购买都会new一个购物车，所以要用session
        cart.addCake(cake);
        session.setAttribute("cart", cart);


        //买完之后回到展示页面，再购买别的蛋糕
        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
