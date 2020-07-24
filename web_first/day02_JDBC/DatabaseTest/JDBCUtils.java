package web_first.day02_JDBC.DatabaseTest;

import java.sql.*;

/**
 * 定义一个JDBC工具类，用于存放冗余的代码
 */
public class JDBCUtils {

    //1.定义几个字符串常量：用户名，密码，URL，驱动类
    private static final String USER = "root";
    private static final String PWD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/db1";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // 2.注册驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 3.得到数据库的连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection( URL, USER, PWD);
    }

    // 4.关闭所有打开的连接
    //4.1如果是打开了两个资源
    public static void close(Connection con, Statement stat) {
        if( stat != null) {
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
    //4.2如果是打开了三个资源
    public static void close(ResultSet rs, Connection con, Statement stat) {
        if( rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close( con, stat);
    }
}
