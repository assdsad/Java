package org.example.filter.order;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter1 init");
    }

    public void destroy() {
        System.out.println("filter1 destory");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter1 begin");
        chain.doFilter(request, response);
        System.out.println("filter1 end");
    }
}