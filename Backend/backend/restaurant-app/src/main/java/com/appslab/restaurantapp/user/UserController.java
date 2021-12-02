package com.appslab.restaurantapp.user;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081/")
public class UserController {

    UserService userService;
    PasswordEncoder passwordEncoder;


    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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
