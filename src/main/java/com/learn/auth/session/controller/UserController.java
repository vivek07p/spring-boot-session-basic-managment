package com.learn.auth.session.controller;


import com.learn.auth.session.model.User;
import com.learn.auth.session.service.UserDetailServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private PasswordEncoder passwordEncoder;
    private UserDetailServiceImpl userService;

    public UserController(PasswordEncoder passwordEncoder, UserDetailServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @GetMapping("user-list")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

}
