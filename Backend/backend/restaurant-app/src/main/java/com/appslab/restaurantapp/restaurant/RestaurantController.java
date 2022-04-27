package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.exception.GenericException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "/createRestaurant")
    public void createRestaurant(@RequestBody Restaurant restaurant, Principal principal)throws GenericException {
        restaurantService.createRestaurant(restaurant, principal);
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurants() {
        return this.restaurantService.getRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable long id) {
        return this.restaurantService.getRestaurantById(id);
    }

    @GetMapping(value = "/getRestaurantsByCategory")
    public List<Restaurant> getRestaurantsByCategory(@RequestParam String category){
        return restaurantService.getRestaurantsByCategory(category);
    }

    @GetMapping(value = "/getRestaurantInfo")
    public Restaurant getRestaurantInfo(@RequestParam long restaurantId){
        return restaurantService.getRestaurantInfo(restaurantId);
    }

    @GetMapping(value = "/getRestaurantsByTime")
    public List<Restaurant> getRestaurantsByTime(@RequestParam LocalTime time){
        return restaurantService.getRestaurantsByTime(time);
    }

    @GetMapping(value = "/getRestaurantsByRegion")
    public List<Restaurant> getRestaurantsByRegion(@RequestParam Restaurant.Region region){
        return restaurantService.getRestaurantsByRegion(region);
    }

    @GetMapping(value = "/getAllRestaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }
}
