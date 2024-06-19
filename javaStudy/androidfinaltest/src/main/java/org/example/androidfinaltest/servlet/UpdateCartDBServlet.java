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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "updateCart", value = "/updateCart")
public class UpdateCartDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SelectedGoods>>(){}.getType();
        List<SelectedGoods> cartList = gson.fromJson(json, listType);

        GoodsDao.updateCartDBbyUsername(cartList.get(0).getUsername(), cartList);
        PrintWriter out = response.getWriter();
        out.write(ResultUtil.success("加入成功", 1));
        out.close();
    }
}
