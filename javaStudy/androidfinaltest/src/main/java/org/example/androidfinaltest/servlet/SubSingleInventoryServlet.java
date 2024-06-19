package org.example.androidfinaltest.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.androidfinaltest.dao.GoodsDao;
import org.example.androidfinaltest.entity.SelectedGoods;
import org.example.androidfinaltest.util.ResultUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

@WebServlet(name = "subSingleInventory", value = "/subSingleInventory")
public class SubSingleInventoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/json;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String id = request.getParameter("id");
//        String count = request.getParameter("count");
//
//        GoodsDao.subInventory(Integer.parseInt(id), Integer.parseInt(count));
////        int cnt = GoodsDao.findInventory(Integer.parseInt(id));
//        PrintWriter out = response.getWriter();
////        out.print("<h1>" + cnt + "</h1>");
//        out.write(ResultUtil.success("购买成功", 1));
//        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Type classType = new TypeToken<SelectedGoods>(){}.getType();
        SelectedGoods good = gson.fromJson(json, classType);
        GoodsDao.subInventory(good.getId(), good.getCount());
        GoodsDao.addOrderFormData(good);
        PrintWriter out = response.getWriter();
//        out.print("<h1>" + cnt + "</h1>");
        out.write(ResultUtil.success("购买成功", 1));
        out.close();
    }
}
