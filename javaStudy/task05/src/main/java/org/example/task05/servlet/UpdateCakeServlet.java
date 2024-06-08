package org.example.task05.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.task05.Dao.CakeDao;

import java.io.IOException;
@WebServlet("/update")
public class UpdateCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取点击“下架”后传来的蛋糕id
        String id = request.getParameter("id");


        CakeDao cakeDao = new CakeDao();
        cakeDao.updateState(Integer.parseInt(id), 2);

        //跳转到listCakeServlet
        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
