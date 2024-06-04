package org.example.chat;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

@WebServlet("/names")
public class NamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用来将用户的名字显示在右边
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html><head><meta http-equiv='refresh' content='1'></head>");//<meta http-equiv='refresh' content='1'>每隔1秒刷新一次
        Object objNames = this.getServletContext().getAttribute("names");
        Object myself = request.getSession().getAttribute("myself");
        if(objNames != null){
            LinkedHashSet<String> names = (LinkedHashSet<String>) objNames;
            names.forEach(name -> {
                if(name.equals(myself)) {
                    out.print("<p><font color='red'>" + name + "</font></p>");//将已有用户的名字显示在页面右边
                } else {//当前用户的名字标红，其他用户显示蓝色
                    out.print("<p><font color='blue'>" + name + "</font></p>");
                }
            });
        }
        out.print("<body>");

        out.print("</body></html>");


        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
