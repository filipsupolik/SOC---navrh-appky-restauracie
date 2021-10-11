package com.appslab.restaurantapp;

import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultInitialization implements CommandLineRunner {

    UserService userService;
    UserRepository userRepository;

    public DefaultInitialization(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.findByUsername("admin").isPresent()==false){
            User user = new User("admin", "admin");
            userService.createUser(user);
        }


    }
}
