package web_first.day02_JDBC.DatabaseConnectionPool;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplate_Test1 {

    public static void main(String[] args) {
        // 1.导入jar包
        // 2.创建JDBCTemplate对象
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataBase());
        // 3.调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = jt.update(sql, 3);
        System.out.println(count);
    }
}
