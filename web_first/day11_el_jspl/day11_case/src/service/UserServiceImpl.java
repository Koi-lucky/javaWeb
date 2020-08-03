package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;

import java.util.List;

public class UserServiceImpl implements service.UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.fingAll();
    }
}
