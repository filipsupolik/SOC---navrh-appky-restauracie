package com.appslab.restaurantapp.user;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface UserService {

    void createUser(User user);
    void assignFavRestaurantToUser(long userId, long restaurantId);
    void removeFavRestaurantFromUser(long userId, long restaurantId);
    Optional<User> getUserByUsername(String username);
}
