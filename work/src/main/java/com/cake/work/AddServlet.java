package com.cake.work;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.cake.work.Constant.cakes;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

//        request.setAttribute("cakeInfo", "oiiiiiiiiiiiiii");

//        PrintWriter out = response.getWriter();
//        out.print("1241");
//        for(String cake : cakes){
//            out.print(cake);
//        }
//        out.flush();
//        out.close();

        //使用a标签
        request.setAttribute("cakeInfo", cakes);
        request.getRequestDispatcher("show").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] cakeInfo = request.getParameterValues("cakes");
        for (String cake : cakeInfo) {
            System.out.println(cake);
            cakes.add(cake);
        }
        //点击确定把信息给ShowServlet
        request.setAttribute("cakeInfo", cakes);
        request.getRequestDispatcher("show").forward(request, response);


//        for(String cake : cakes){
//            System.out.print(cake + "     ");
//        }
//        System.out.println();
        //要先按右边的确定，把蛋糕的种类加入到list中
        //再按下方的confirm才能把存有蛋糕信息的list传给ShowServlet
    }


}
