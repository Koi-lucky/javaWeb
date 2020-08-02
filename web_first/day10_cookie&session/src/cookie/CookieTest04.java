package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieTest04")
public class CookieTest04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象，绑定数据
        Cookie c = new Cookie("msg", "setMaxAge");
        //设置Cookie存活时间
        //c.setMaxAge(30);//正数表示：将cookie持久化到硬盘。关闭浏览器之后，30S后就自动销毁
        //c.setMaxAge(-1);//负数表示：默认值，也就是浏览器关闭，数据就销毁
        c.setMaxAge(0);//0表示：把服务器中的文件删除

        // 2.发送Cookie对象
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
