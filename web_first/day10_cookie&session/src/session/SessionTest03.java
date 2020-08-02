package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionTest03")
public class SessionTest03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用Session共享数据

        //1.获取Session
        HttpSession ss = request.getSession();
        System.out.println(ss);

        //期望：客户端关闭，再次开启后，得到的session相同
        Cookie ck = new Cookie( "JSESSIONID", ss.getId());//自己设置一个cookie
        ck.setMaxAge(60 * 60);//设置有效时间为一个小时
        response.addCookie(ck);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
