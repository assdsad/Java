package org.example.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//Filter的执行过程  加载， 实例化， 初始化， 过滤， 销毁

public class CharFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        System.out.println("filter begin");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter end");

//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        res.sendRedirect("");
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
