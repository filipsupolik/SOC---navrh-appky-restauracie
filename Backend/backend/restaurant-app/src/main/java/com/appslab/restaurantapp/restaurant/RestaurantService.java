package com.appslab.restaurantapp.restaurant;


import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    void createRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantsByCategory(String category);
    Optional<Restaurant> getRestaurantById(long id);
    Restaurant getRestaurantInfo(Long restaurantId);
}
