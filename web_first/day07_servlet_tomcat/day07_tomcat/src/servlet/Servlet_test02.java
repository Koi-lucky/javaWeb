package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 【生命周期】
 */
public class Servlet_test02 implements Servlet {
    //Servlet被创建，用于加载资源
    // 只执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init~~~~~~~");
    }

    //获取配置信息
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务
    // 每执行一次Servlet方法，就提供一次服务
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet~~~");
    }

    //获取Servlet信息
    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁方法，用于释放资源
    // 执行destroy方法，只执行一次
    @Override
    public void destroy() {
        System.out.println("destroy~~~~~");
    }
}
