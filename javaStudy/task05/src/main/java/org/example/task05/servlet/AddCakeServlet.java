package org.example.task05.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.task05.Dao.CakeDao;
import org.example.task05.entity.Cake;

import java.io.IOException;
@WebServlet("/add")
public class AddCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        Cake cake = new Cake();
        cake.setName(name);
        cake.setPrice(Integer.parseInt(price));
        cake.setState(1);

        CakeDao cakeDao = new CakeDao();
        cakeDao.saveCake(cake);

        response.sendRedirect("list");




    }
}
