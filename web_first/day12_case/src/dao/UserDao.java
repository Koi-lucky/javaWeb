package dao;

import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    //查询所有记录的方法
    public abstract List<User> fingAll();

    //按照id查询用户名和登录密码的方法
    public abstract User findUserByPasswordAndUsername(String username, String password);

    //添加方法
    public void add(User user);

    //删除方法
    void delete(int id);

    //根据id查找
    User findById(int id);

    //修改用户信息
    void update(User user);

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    //分页查询每页的记录数
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
