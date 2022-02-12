package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.security.UserDetailsServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;
    PasswordEncoder passwordEncoder;
    UserDetailsServiceImpl userDetailsService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, UserDetailsServiceImpl userDetailsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/register")
    public void createUser(@RequestBody User user)throws GenericException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }

    @GetMapping(value = "/login")
    public User login(){
        return userService.getCurrentUser();
    }

    @GetMapping(value = "/getCurrentUser")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

}
