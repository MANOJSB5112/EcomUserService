package com.example.ecomuserservice.service;

import com.example.ecomuserservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getSingleUser(Long id) throws Exception;
    void addUser(User user);
    void updateUser(Long id,User user) throws Exception;

    void deleteUser(Long id) throws Exception;
}
