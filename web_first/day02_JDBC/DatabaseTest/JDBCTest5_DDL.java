package web_first.day02_JDBC.DatabaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *   处理DDL语言
 * 【注意】了解就可以，一般不常用，数据库中的数据已经给好，
 */
public class JDBCTest5_DDL {

    public static void main(String[] args) {
        Connection con = null;
        Statement stat = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
            // 3.定义sql语句
            String sql = "create table course( id int, name varchar(20))";
            // 4.获取执行sql的对象
            stat = con.createStatement();
            // 5.执行sql语句
            int val = stat.executeUpdate(sql);//处理DDL语句——【此处无返回值】
            // 6.处理结果
            System.out.println(val);//0
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源
            if( stat != null) {//避免空指针异常
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if( con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
