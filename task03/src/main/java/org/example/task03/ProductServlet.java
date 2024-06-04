package org.example.task03;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //全部链接的访问次数
        Object obj = this.getServletContext().getAttribute("countAll");
        if(obj == null) {//第一次访问
            this.getServletContext().setAttribute("countAll", 1);
        } else {
            int countAll = Integer.parseInt(obj.toString());
            countAll++;
            this.getServletContext().setAttribute("countAll", countAll);
        }

//        自己访问的次数
        String id = request.getParameter("id");
        Object objCount = request.getSession().getAttribute("count");
        List<Integer> count;
        if(objCount == null) {
            count = new ArrayList<>();
            for(int i = 0 ; i < 10; i++){
                count.add(0);
            }
        } else{
            count = (ArrayList<Integer>) objCount;
        }
        count.set(Integer.parseInt((id)) - 1, count.get(Integer.parseInt(id) - 1) + 1);
        request.getSession().setAttribute("count", count);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
