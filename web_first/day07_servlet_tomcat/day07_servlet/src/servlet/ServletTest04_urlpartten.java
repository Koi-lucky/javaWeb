package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet({"/d4", "/dd4", "/ddd4", "/dddd4"})  //有多条路径可以访问到这个类
@WebServlet("/user/d4")  //双层路径访问
//@WebServlet("/user/*")  //第一层路径确定，第二层路径随意写就可以访问
//@WebServlet("/*")  //加斜杠。路径随意写就可以访问，但是要加斜杠
//@WebServlet("*.do")  //不加斜杠。路径随意写，但是.do必须写【自定义的路径后缀（.do），必须写】
public class ServletTest04_urlpartten extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test04~~~~~");
    }
}
