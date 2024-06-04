package org.example.chat;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/msgs")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用来显示说的话
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta http-equiv='refresh' content='1'></head><body>");
        //每隔1秒刷新一次页面

        Object objMsgs = this.getServletContext().getAttribute("msgs");
        if(objMsgs != null) {
            List<String> msgs = (List<String>) objMsgs;
            msgs.forEach(msg -> {
                //将说的话显示在页面上
                out.print("<p>" + msg + "</p>");
            });
        }

        out.println("</body></html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
