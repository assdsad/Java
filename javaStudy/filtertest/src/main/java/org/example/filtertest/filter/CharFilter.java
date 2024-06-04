package org.example.filtertest.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destory");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("filter begin");
        chain.doFilter(request, response);
        System.out.println("filter end");
    }
}