package com.appslab.restaurantapp;

import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultInitialization implements CommandLineRunner {

    UserService userService;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public DefaultInitialization(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        User user = new User("admin","password","admin@admin.admin");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userService.getUserByUsername("admin").isEmpty()==true) {
            userService.createUser(user);
        }

    }
}
