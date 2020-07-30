package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response_test04")
public class Response_test04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取字节输出流
        ServletOutputStream os = response.getOutputStream();
        //2.输出数据
        os.write("你好啊啊啊啊啊  response~~~".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost( request, response);
    }
}
