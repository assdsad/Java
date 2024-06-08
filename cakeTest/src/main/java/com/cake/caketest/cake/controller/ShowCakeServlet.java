package com.cake.caketest.cake.controller;

import com.cake.caketest.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/show")
public class ShowCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Object obj = request.getAttribute("cakes");
        if (obj == null) {
            out.print("<h1>无蛋糕数据</h1>");
        } else {
            List<Cake> cakes = (List<Cake>) obj;
            if(cakes.size() == 0){
                out.print("<h1>无蛋糕数据</h1>");
            } else{
                out.print("<html><body><table border='1'>");
                out.print("<tr><td>编号</td><td>名称</td><td>价格</td><td>操作</td></tr>");
                for(Cake cake : cakes){
                    out.print("<tr><td>" + cake.getId() + "</td><td>" +
                            cake.getName() + "</td><td>" +
                            cake.getPrice() + "</td><td>" +
                            "<a href='edit?id=" + cake.getId() + "'>修改</a>" +//通过servlet
//                            "<a href='editCake.html?editId=" + cake.getId() + "'>修改</a>" +//通过javascript
                            " <a href='delete?id=" + cake.getId() + "'>删除</a>" +//点击删除后，把要删除蛋糕的id传过去
                            " <a href='buy?id=" + cake.getId() + "'>购买</a>" +//买的是这个id的蛋糕
                            " <a href='comment?id=" + cake.getId() + "'>评论</a>" +//买的是这个id的蛋糕
                            "</td></tr>");
                }
                out.print("</table> " +"</br>" +
                        "<a href='showcart'>查看购物车</a>" +
                        "</body></html>");
                out.flush();
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
