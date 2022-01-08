package com.appslab.restaurantapp.restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/getRestaurantsByCategory")
    public List<Restaurant> getRestaurantsByCategory(@RequestParam String category){
        return restaurantService.getRestaurantsByCategory(category);
    }

    @GetMapping(value = "/getRestaurantInfo")
    public Restaurant getRestaurantInfo(@RequestParam Long restaurantId){
        return restaurantService.getRestaurantInfo(restaurantId);
    }
}
