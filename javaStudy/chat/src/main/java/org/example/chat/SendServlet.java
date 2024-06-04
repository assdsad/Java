package org.example.chat;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/send")
public class SendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用来发送信息
        String msg = request.getParameter("msg");
        Object myself = request.getSession().getAttribute("myself");

        //将说的话存在集合中
        Object objMsgs = this.getServletContext().getAttribute("msgs");
        List<String> msgs;
        if (objMsgs == null) {//第一个人说话
            msgs = new ArrayList<>();
        } else {
            msgs = (List<String>) objMsgs;
        }
        msgs.add(myself + "说：" + msg);
        this.getServletContext().setAttribute("msgs", msgs);

        //说完之后还可以继续说
        response.sendRedirect("send.html");
    }
}
