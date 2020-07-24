package web_first.day02_JDBC.DatabaseTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 用户登录案例
 * 【注意】放置sql注入问题的发生 —— 使用PrepareStatement
 */
public class JDBCTest9_UserLogin {

    //从控制台输入用户名和密码
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请用户输入姓名：");
        String name = sc.nextLine();
        System.out.println("请用户输入密码：");
        String pwd = sc.nextLine();
        login( name, pwd);
    }

    //登录的方法
    private static void login(String name, String pwd) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        //写成登录sql语句，没有单引号
        String sql = "select * from user where name = ? and password = ? ";
        //得到语句对象
        PreparedStatement ps = con.prepareStatement(sql);
        //设置参数
        ps.setString(1, name);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            System.out.println("登录成功:" + name);
        } else {
            System.out.println("登录失败~");
        }
        //释放资源，子接口直接给父接口
        JDBCUtils.close( rs, con, ps);
    }
}
