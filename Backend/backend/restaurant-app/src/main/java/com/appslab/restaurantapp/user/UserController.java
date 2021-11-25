package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.securityOLD.UserDetailsServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081/")
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
    public void createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }

    @PostMapping(value = "/assignFavRestaurantsToUser")
    public void assignFavRestaurantsToUser(@RequestParam long userId, @RequestParam long restaurantId){
        userService.assignFavRestaurantToUser(userId, restaurantId);
    }

    @PostMapping(value = "/removeFavRestaurantsFromUser")
    public void removeFavRestaurantsFromUser(@RequestParam long userId, @RequestParam long restaurantId){
        userService.removeFavRestaurantFromUser(userId, restaurantId);
    }

    @GetMapping(value = "/login")
    public User login(){
        return userService.getCurrentUser();
    }

}
