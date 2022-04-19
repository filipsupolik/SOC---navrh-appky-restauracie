package com.appslab.restaurantapp.restaurant;


import com.appslab.restaurantapp.exception.GenericException;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    void createRestaurant(Restaurant restaurant, Principal principal)throws GenericException;
    List<Restaurant> getRestaurantsByCategory(String category);
    Optional<Restaurant> getRestaurantById(long id);
    Restaurant getRestaurantInfo(Long restaurantName);
    List<Restaurant> getRestaurantsByTime(LocalTime time);
    List<Restaurant> getRestaurantsByRegion(Restaurant.Region region);
}
