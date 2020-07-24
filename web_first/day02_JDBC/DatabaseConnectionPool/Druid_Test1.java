package web_first.day02_JDBC.DatabaseConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 演示Druid
 */
public class Druid_Test1 {

    public static void main(String[] args) throws Exception {
        //1.导入jar包
        // 2.定义配置文件
        // 3.加载配置文件
        Properties pro = new Properties();
        InputStream is = Druid_Test1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        // 4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        // 5.获取连接
        Connection con = ds.getConnection();
        System.out.println(con);
    }
}
