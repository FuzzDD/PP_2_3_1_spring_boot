package org.example.PP_2_3_1_spring_boot.service;

import org.example.PP_2_3_1_spring_boot.dao.UserDao;
import org.example.PP_2_3_1_spring_boot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void update(int id, User updatetUser) {
    userDao.update(id, updatetUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
    userDao.delete(id);
    }
}
