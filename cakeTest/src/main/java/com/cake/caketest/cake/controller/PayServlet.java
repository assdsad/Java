package com.cake.caketest.cake.controller;

import com.cake.caketest.cake.service.Cart;
import com.cake.caketest.cake.service.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        HashMap<Integer, CartItem> map = cart.getMap();
        int count = 0;
        for(CartItem item : map.values()) {
            count += item.getCount() * item.getCake().getPrice();
        }
        PrintWriter out = response.getWriter();
        out.print("需要支付" + count + "元");
        out.print("<html><body>" +
                "<img src='https://img-blog.csdnimg.cn/direct/e9bffe66d1f8461eae1eb44ae182ad8d.jpeg' width=500 height=500>" +
                "</body></html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
