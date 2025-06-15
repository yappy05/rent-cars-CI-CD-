package com.example.carsharing.service;

import com.example.carsharing.model.User;

import java.util.List;

public interface UserService {
    List<User> readAllUsers();
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
