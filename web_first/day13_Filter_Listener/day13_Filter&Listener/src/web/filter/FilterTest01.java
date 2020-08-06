package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")//配置拦截路径 —— 表示在访问所有资源之前，都会执行该过滤器
public class FilterTest01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter方法执行了.......");

        //放行的方法
        filterChain.doFilter( servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
