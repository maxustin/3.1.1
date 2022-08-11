package com.example.us_spring_boot.dao;

import com.example.us_spring_boot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(long id);
    User getUserById(long id);
    void updateUser(User user);
}
