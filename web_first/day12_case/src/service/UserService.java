package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //查询方法
    public abstract List<User> findAll();

    //登陆方法
    public abstract User login(User user);

    //添加方法
    public void addUser(User user);

    //根据id删除方法
    public void deleteUser(String id);

    //根据id查询用户信息
    User findUserById(String id);

    //修改用户信息
    void updateUser(User user);

    //批量删除页面选中的用户
    void delSelectedUser(String[] ids);

    //分页条件查询
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
