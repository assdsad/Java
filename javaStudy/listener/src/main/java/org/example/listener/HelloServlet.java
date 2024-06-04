package org.example.listener;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//        this.getServletContext().setAttribute("un", "zhangsan");//添加，这行代码执行，xxxAttributeListener就会执行
//        this.getServletContext().setAttribute("un", "lisi");//修改
////        this.getServletContext().removeAttribute("un");//删除数据会执行attributeRemoved
//
        request.getSession().setAttribute("age", 20);//不执行BindingListener,执行HttpSessionAttributeListener
        request.getSession().setAttribute("ttttt", new MyHttpSessionBindingListener());
////        只有在session中存实现HttpSessionBindingListener接口的类的对象时才会执行BindingListener

//        request.getSession().setAttribute("age", 10);
//        HttpSession session = request.getSession();
//        session.setAttribute("age", 10);
//        session.setAttribute("age", 20);
//        session.removeAttribute("age");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}