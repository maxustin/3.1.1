package com.example.us_spring_boot.service;

import com.example.us_spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsersFromDatabase();
    void addUserToDatabase(User user);
    void removeUserByIdFromDatabase(long id);
    User getUserByIdFromDatabase(long id);
    void updateUserInDatabase(User user);
}
