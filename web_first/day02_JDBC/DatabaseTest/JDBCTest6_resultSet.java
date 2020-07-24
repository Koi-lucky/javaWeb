package web_first.day02_JDBC.DatabaseTest;

import java.sql.*;

public class JDBCTest6_resultSet {

    public static void main(String[] args) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
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
            rs = stat.executeQuery(sql);//此处用resultSet包
            // 6.处理结果
            //此处直接用循环读取文件
            while(rs.next()) {//如果rs.next有下一行，就一直获取
                //获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);

                System.out.println( id + " -- " + name + " -- " + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源
            if( rs != null) {//避免空指针异常
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
