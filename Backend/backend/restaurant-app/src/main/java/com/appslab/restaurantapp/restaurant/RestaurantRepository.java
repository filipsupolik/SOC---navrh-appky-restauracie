package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long restaurantId);
    Optional<Restaurant> findByRestaurantName(String restaurantName);
    Optional<Restaurant> findByAdminId(Long adminId);
    List<Restaurant> findByRegion(Restaurant.Region region);
}
