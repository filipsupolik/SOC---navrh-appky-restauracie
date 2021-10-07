package com.appslab.restaurantapp.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody User user){
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
