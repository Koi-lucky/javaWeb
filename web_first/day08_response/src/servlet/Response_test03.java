package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//重定向
@WebServlet("/response_test03")
public class Response_test03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //【太麻烦】①在获取流对象前，要先将流的默认编码：ISO-8859-1 设置为：GBK
        //response.setCharacterEncoding("utf-8");
        //【比较麻烦】②告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码进行解码
        //response.setHeader("content-type", "text/html;charset=utf-8");//不仅设置了流的编码，而且还建议浏览器使用该形式解码
        //【简单】③简单形式，设置编码
        response.setContentType("text/html;charset=utf-8");//在获取流对象前,设置了流的编码，建议浏览器使用该形式解码

        //1.获取字节输出流
        PrintWriter pw = response.getWriter();
        // 2.输出数据
        /*pw.write("<h1>hello,response!!!!</h1>");*/
        pw.write("你好啊啊啊啊 ,response!!!!");//在浏览器中，中文会乱码，因为解码和编码的字符集不一致
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost( request, response);
    }
}
