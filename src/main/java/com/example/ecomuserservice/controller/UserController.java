package com.example.ecomuserservice.controller;

import com.example.ecomuserservice.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    List<User> getAllUsers();
     User getSingleUser(Long id) throws Exception;
//    void addUser();

    @PutMapping("/{id}")
    void updateUser(@PathVariable Long id, @RequestBody User user) throws Exception;

    void deleteUser(Long id) throws Exception;

}
