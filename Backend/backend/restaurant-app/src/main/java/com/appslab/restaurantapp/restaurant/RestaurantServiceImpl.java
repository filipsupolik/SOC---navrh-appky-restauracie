package com.appslab.restaurantapp.restaurant;

import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}
