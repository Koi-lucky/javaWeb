package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.fingAll();
    }

    @Override
    public User login( User user) {
        return userDao.findUserByPasswordAndUsername(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        //遍历数组
        for (String id : ids) {
            //调用userDao删除
            userDao.delete(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0) {
            currentPage = 1;
        }


        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();
        // 2.设置当前页面属性和rows属性
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        // 3.调用userDao查询totalCount总记录数
        int totalCount = userDao.findTotalCount(condition);
        // 4.计算开始的记录索引
        int start = (currentPage - 1) * rows;
        // 5.调用userDao查询list集合
        List<User> list = userDao.findByPage(start,rows,condition);
        pb.setList(list);
        // 6.计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        // 7.返回PageBean对象
        return pb;
    }

}
