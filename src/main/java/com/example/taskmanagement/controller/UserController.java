package com.example.taskmanagement.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
