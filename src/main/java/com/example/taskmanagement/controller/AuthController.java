package com.example.taskmanagement.controller;

import com.example.taskmanagement.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        String role = "USER"; // example
        return jwtUtil.generateToken(username,role);
    }
}
