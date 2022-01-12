package com.appslab.restaurantapp.restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable long id) {
        return this.restaurantService.getRestaurantById(id);
    }

    @GetMapping(value = "/getRestaurantsByCategory")
    public List<Restaurant> getRestaurantsByCategory(@RequestParam String category){
        return restaurantService.getRestaurantsByCategory(category);
    }
}
