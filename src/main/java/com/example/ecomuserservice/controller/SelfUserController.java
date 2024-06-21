package com.example.ecomuserservice.controller;

import com.example.ecomuserservice.model.User;
import com.example.ecomuserservice.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Getter
@Setter
@RestController
@RequestMapping("/selfusers")
public class SelfUserController implements UserController {
    UserService userService;

    SelfUserController(@Qualifier("selfUserService")UserService userService)
    {
        this.userService=userService;
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

    @Override
    @PatchMapping("/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody User user) throws Exception {
        userService.updateUser(id,user);
    }


    @PostMapping()
    public void addUser( @RequestBody User user) {
       userService.addUser(user);
    }
//
//   @Override
//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable Long id, @RequestBody User user) {
//        userService.updateUser(id);
//    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
    }
}
