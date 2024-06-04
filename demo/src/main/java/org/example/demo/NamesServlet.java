package org.example.demo;

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta http-equiv='refresh' content='1' /></head><body>");
        Object objNames = this.getServletContext().getAttribute("names");
        Object myself = request.getSession().getAttribute("myself");
        if(objNames != null) {
            LinkedHashSet<String> names = (LinkedHashSet<String>) objNames;
            names.forEach(name -> {
                if(myself.equals(name)) {
                    out.println("<p><font color='red'>" + name + "</font></p>");
                }else {
                    out.println("<p><font color='blue'>" + name + "</font></p>");
                }

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
