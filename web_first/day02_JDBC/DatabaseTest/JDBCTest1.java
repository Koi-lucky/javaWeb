package web_first.day02_JDBC.DatabaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest1 {

    public static void main(String[] args) throws Exception {
        //1.导入jar包
        // 2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
        // 4.定义sql语句
        String sql = "update student set grade = 70 where s_id = 10010 and course = '计算机基础'";
        // 5.获取执行sql的对象
        Statement stat = con.createStatement();
        // 6.执行sql
        int count = stat.executeUpdate(sql);
        // 7.处理结果——打印结果
        System.out.println(count);
        // 8.释放资源
        stat.close();
        con.close();
    }
}
