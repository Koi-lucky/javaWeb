package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

//操作数据库中User表的类
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //登陆方法
    //输入的只有用户名和密码，输出的是用户的全部信息
    public User login(User loginUser) {
        try {
            //1.编写SQL语句
            String sql = "select * from user where username = ? and passward = ?";
            // 2.调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());

            //如果用户存在，就返回
            return user;
        } catch (Exception e) {
            e.getMessage();
            //用户不存在，返回空
            return null;
        }
    }
}
