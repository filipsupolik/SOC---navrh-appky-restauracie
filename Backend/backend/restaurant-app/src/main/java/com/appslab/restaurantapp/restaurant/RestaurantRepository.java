package com.appslab.restaurantapp.restaurant;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long restaurantId);
}
