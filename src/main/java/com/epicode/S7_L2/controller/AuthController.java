package com.epicode.S7_L2.controller;

import com.epicode.S7_L2.model.User;
import com.epicode.S7_L2.security.JwtUtil;
import com.epicode.S7_L2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    public AuthController() {
    }

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userService.registerUser(user);
        return "user register successfully!👍";
    }
}
