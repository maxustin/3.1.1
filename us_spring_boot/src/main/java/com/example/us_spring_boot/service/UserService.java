package com.example.us_spring_boot.service;

import com.example.us_spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    void saveUser(User user);
    void removeUserById(long id);
    User findUserById(long id);
}
