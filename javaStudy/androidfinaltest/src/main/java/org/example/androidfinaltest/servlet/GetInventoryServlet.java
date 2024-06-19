package org.example.androidfinaltest.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.androidfinaltest.dao.GoodsDao;
import org.example.androidfinaltest.util.ResultUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "inventory", value = "/inventory")
public class GetInventoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/json;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        String id = request.getParameter("id");
//        int count = GoodsDao.findInventory(Integer.parseInt(id));
//        PrintWriter os = response.getWriter();
//        os.write("<h1>" + count + "</h1>");
//        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        int count = GoodsDao.findInventory(Integer.parseInt(id));
        PrintWriter os = response.getWriter();
        os.write(ResultUtil.success("访问成功", count));
        os.close();
    }
}
