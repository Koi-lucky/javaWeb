package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//重定向
@WebServlet("/response_test01")
public class Response_test01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test01.......~~~~");

        /*
        //访问/response_test01时，会自动跳转到/response_test02资源
        //1.设置状态码为302
        response.setStatus(302);
        // 2.设置响应头location
        response.setHeader("location", "/day08_response_war_exploded/response_test02");
        */

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的重定向方法
        response.sendRedirect( contextPath +"/response_test02");//以免出错，让它自动获取虚拟目录
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost( request, response);
    }
}
