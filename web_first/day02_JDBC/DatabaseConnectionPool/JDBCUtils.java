package web_first.day02_JDBC.DatabaseConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 构造一个工具类，用于存储冗余的代码
 */
public class JDBCUtils {

    //1.定义成员变量Database
    private static DataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 2.获取Database
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2.获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 3.释放资源 —— 此处也就是归还资源
    //3.1如果是打开了两个资源
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
    //3.2如果是打开了三个资源
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


    //4.获取连接池
    public static DataSource getDataBase() {
        return ds;
    }
}
