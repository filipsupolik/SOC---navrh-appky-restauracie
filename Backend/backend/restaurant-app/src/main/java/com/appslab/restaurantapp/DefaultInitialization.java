package com.appslab.restaurantapp;

import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.AppUserRole;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DefaultInitialization implements CommandLineRunner {

    UserService userService;
    UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void run(String... args) throws Exception {
        User user = new User("admin", "mail@mail.com", "password", AppUserRole.ADMIN);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if (userRepository.findByUsername("admin").isEmpty()) {
            userRepository.save(user);
        }

    }
}
