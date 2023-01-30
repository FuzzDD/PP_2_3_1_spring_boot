package org.example.PP_2_3_1_spring_boot.dao;

import org.example.PP_2_3_1_spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsersList();
    void add(User user);
    public User show(int id);
    public void update(int id, User updatetUser);
    public void delete(int id);
}
