package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.securityOLD.UserDetailsServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
