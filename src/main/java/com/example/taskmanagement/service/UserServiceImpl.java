package com.example.taskmanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
