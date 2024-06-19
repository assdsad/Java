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

@WebServlet(name = "cartPay", value = "/cartPay")
public class CartPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取到从安卓端传输过来的购物车中的商品信息
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SelectedGoods>>(){}.getType();
        List<SelectedGoods> goodsList = gson.fromJson(json, listType);

        GoodsDao.subVariesInventory(goodsList);//购买后修改库存
        //在orderform表中生成订单
        GoodsDao.addOrderFormData(goodsList);
        PrintWriter out = response.getWriter();
        out.write(ResultUtil.success("购买成功", 1));
        out.close();
    }
}
