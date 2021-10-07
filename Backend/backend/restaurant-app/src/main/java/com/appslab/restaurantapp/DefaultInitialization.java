package com.appslab.restaurantapp;

import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultInitialization implements CommandLineRunner {

    UserService userService;

    public DefaultInitialization(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Martin", "password");
        userService.createUser(user);
    }
}
