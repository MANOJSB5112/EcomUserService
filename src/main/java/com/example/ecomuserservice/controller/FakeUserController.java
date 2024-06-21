package com.example.ecomuserservice.controller;

import com.example.ecomuserservice.model.User;
import com.example.ecomuserservice.service.FakeUserService;
import com.example.ecomuserservice.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Controller
@Getter
@Setter
public class FakeUserController implements UserController {
    UserService userService;

    @Autowired
    FakeUserController(FakeUserService fakeUserService)
    {
        this.userService=fakeUserService;
    }

    @Override
    @GetMapping()
    public List<User> getAllUsers() {
       return userService.getAllUsers();
    }

    @Override
    @GetMapping("/{id}")
    public User getSingleUser(@PathVariable Long id) throws Exception {
        return userService.getSingleUser(id);
    }

//    @PostMapping("/{id}")
//    public void addUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.addUser(id);
//    }

    @Override
    public void updateUser(Long id ,User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
