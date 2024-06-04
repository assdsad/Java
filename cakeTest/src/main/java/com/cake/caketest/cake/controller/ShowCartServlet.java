package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.Cart;
import com.cake.caketest.cake.service.CartItem;
import com.cake.caketest.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/showcart")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("cart");
        if(obj == null){
            out.println("购物车为空");
        } else {
            Cart cart = (Cart)obj;
            HashMap<Integer, CartItem> map = cart.getMap();
            map.values().forEach(cartItem -> {
                out.print(cartItem.getCake().getName() + ":  " + cartItem.getCount());
            });
            out.print("<html><body>");
            out.print("<a href='pay'>支付</a>");
            out.print("</body></html>");
        }




        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
