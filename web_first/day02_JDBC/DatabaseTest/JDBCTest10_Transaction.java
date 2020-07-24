package web_first.day02_JDBC.DatabaseTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务的处理 —— 开启事务，提交事务，回滚事务
 */
public class JDBCTest10_Transaction {

    //没有异常，提交事务；出现异常，回滚事务
    public static void main(String[] args) {
        //1.注册驱动
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 2.获取连接
            con = JDBCUtils.getConnection();
            // 3.开启事务
            con.setAutoCommit(false);
            // 4.获取到PrepareStatement
              //扣钱
            ps = con.prepareStatement("update account set balance = balance - ? where name = ? ");
            ps.setInt(1, 500);
            ps.setString(2, "Jack");
            ps.executeUpdate();
              // 出现了异常
            System.out.println(100 / 0);
              // 加钱
            ps = con.prepareStatement("update account set balance = balance + ? where name = ? ");
            ps.setInt(1, 500);
            ps.setString(2, "Rose");
            ps.executeUpdate();
            // 5.提交事务
            con.commit();
            System.out.println("转账成功！！");
        } catch (SQLException e) {
            e.printStackTrace();
            // 6.事务的回滚
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("转账失败~");
        } finally {
            // 7.关闭资源
            JDBCUtils.close( con, ps);
        }
    }
}
