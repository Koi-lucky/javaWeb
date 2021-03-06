package web_first.day02_JDBC.DatabaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除表中的记录 —— delete语句
 */
public class JDBCTest4_deletet {

    public static void main(String[] args) {
        Connection con = null;
        Statement stat = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
            // 3.定义sql语句
            String sql = "delete from student where course = '计算机基础'";
            // 4.获取执行sql的对象
            stat = con.createStatement();
            // 5.执行sql语句
            int val = stat.executeUpdate(sql);
            // 6.处理结果
            System.out.println(val);
            if(val > 0) {
                System.out.println("删除数据成功！！");
            } else {
                System.out.println("删除数据失败！！");
            }
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
