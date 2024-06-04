package org.example.task03;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showCount")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Object countAll = this.getServletContext().getAttribute("countAll");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(countAll == null){
            out.println("总共访问了0次" + "</br>");
        } else {
            out.println("总共访问了" + countAll + "次" + "</br>");
        }

        Object obj = request.getSession().getAttribute("count");
        if(obj != null){
            List<Integer> count = (List<Integer>) obj;
            for(int i = 0; i< 10; i++){
                if(count.get(i) == 0){
                    continue;
                } else {
                    int index = i + 1;
                    out.println("产品" + index + "访问了" + count.get(i) + "次" + "</br>");
                }
            }
        }
        out.println("</body></html>");


        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
