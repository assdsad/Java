package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/cake/*")//执行cake文件夹下的所有
//如果直接是/*会形成死循环
public class PermissionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object un = req.getSession().getAttribute("un");
        if(un != null) {
            filterChain.doFilter(servletRequest, servletResponse);//继续执行后续代码
        } else {
            //防止未登录但是知道网页地址直接访问
            ((HttpServletResponse)servletResponse).sendRedirect("/filter_war_exploded/index.jsp");// ”/index.jsp“加/表示tomcat的根目录
//            req.getRequestDispatcher("/index.jsp").forward(req, servletResponse);//这里的/表示当前项目的根目录
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
