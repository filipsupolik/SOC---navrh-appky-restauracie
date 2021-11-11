package com.appslab.restaurantapp.restaurant;


import java.util.List;

public interface RestaurantService {

    void createRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantsByCategory(String category);
}
