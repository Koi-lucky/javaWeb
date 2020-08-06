package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterTest07 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterTest07被执行了~~~");
        //放行
        chain.doFilter(req, resp);
        System.out.println("FilterTest07回来了~~~");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}
