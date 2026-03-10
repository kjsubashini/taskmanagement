package com.example.taskmanagement.service;

import java.util.List;
import com.example.taskmanagement.model.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();
}