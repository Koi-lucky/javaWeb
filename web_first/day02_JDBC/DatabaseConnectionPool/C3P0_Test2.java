package web_first.day02_JDBC.DatabaseConnectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0_Test2 {

    public static void main(String[] args) throws SQLException {
        //1.使用默认配置获取数据库连接池连接
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接
        for (int i = 0; i < 10; i++) {//若没有连接归还，最大可获取10个连接
            Connection con = ds.getConnection();
            System.out.println(con);
            if(i == 5) {
                con.close();//归还连接到连接池中，下一个连接就可以使用该连接
                //此时最大可获取11个连接
            }
        }
    }
}
