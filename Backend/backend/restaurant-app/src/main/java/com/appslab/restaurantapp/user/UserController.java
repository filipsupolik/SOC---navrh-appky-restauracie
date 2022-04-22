package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.securityOLD.UserDetailsServiceImpl;
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
    public void createUser(@RequestBody RegistrationDto registrationDto) throws GenericException {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(this.passwordEncoder.encode(registrationDto.getPassword()));
        user.setEmail(registrationDto.getEmail());
        user.setAddress(registrationDto.getAddress());
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
