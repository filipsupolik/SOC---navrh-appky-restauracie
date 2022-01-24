package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long restaurantId);
    Optional<Restaurant> findByRestaurantName(String restaurantName);
}
