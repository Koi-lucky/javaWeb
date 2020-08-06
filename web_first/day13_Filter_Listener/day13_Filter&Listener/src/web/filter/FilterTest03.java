package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterTest03 implements Filter {

    //每一次请求被拦截资源时，会执行。执行多次
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /**
         * 1.执行过滤器
         * 2.执行放行后的资源
         * 3.回来执行过滤器放行代码下边的代码
         */
        System.out.println("doFilter.......");
        //放行
        chain.doFilter(req, resp);
    }

    //用于加载资源
    //当服务器启动时，会创建一个Filter对象，然后调用init方法。只执行一次
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init.......");
    }

    //用于释放资源
    //在服务器关闭后，Filter对象被销毁。如果服务器正常关闭，会执行该方法。在服务器关闭后，只执行一次
    public void destroy() {
        System.out.println("destroy.......");
    }
}
