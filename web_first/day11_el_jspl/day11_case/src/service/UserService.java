package service;

import domain.User;

import java.util.List;

public interface UserService {

    public abstract List<User> findAll();
}
