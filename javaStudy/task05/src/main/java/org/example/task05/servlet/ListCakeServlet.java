package org.example.task05.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.task05.Dao.CakeDao;
import org.example.task05.entity.Cake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        CakeDao cakeDao = new CakeDao();
        List<Cake> cakeList = new ArrayList<>();
        cakeList = cakeDao.findByNormalState();

        //以表格的形式输出在页面上
        PrintWriter out = response.getWriter();

        if(cakeList.size() == 0) {
            out.print("<h1>无在售蛋糕</h1>");
        } else {
            out.print("<html><body><table border='1'>");
            out.print("<tr><td>编号</td><td>名称</td><td>价格</td><td>操作</td></tr>");
            for(Cake cake : cakeList) {
                out.print("<tr><td>" + cake.getId()+ "</td><td>" +
                        cake.getName() + "</td><td>" +
                        cake.getPrice() + "</td><td>" +
                        "<a href='update?id=" + cake.getId() +"'>下架</a>" +
                        "</td></tr>");

            }
            out.print("</body></html>");
            out.flush();
            out.close();
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
