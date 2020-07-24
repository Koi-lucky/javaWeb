package web_first.day02_JDBC.DatabaseConnectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0使用演示
 */
public class C3P0_Test1 {

    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2.获取连接对象
        Connection con = ds.getConnection();
        // 3.打印
        System.out.println(con);
    }
}
