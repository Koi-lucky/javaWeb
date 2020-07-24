package web_first.day02_JDBC.DatabaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试一下构造的工具类:
 *      完成添加操作，给account表添加一条记录
 */
public class Druid_Test2 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 1.获取连接
            con = JDBCUtils.getConnection();
            // 2.定义sql
            String sql = "insert into account values(null, ?, ?)";
            // 3.获取stat对象
            ps = con.prepareStatement(sql);
            // 4.给？赋值
            ps.setString(1, "王五");
            ps.setDouble(2, 1000);
            // 5.执行sql
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //归还资源
            JDBCUtils.close(con, ps);
        }

    }
}
