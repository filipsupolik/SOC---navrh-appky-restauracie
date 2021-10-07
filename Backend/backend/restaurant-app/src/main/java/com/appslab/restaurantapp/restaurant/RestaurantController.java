package com.appslab.restaurantapp.restaurant;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "/createRestaurant")
    public void createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.createRestaurant(restaurant);
    }
}
