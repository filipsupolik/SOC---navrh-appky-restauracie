package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RestaurantRepository restaurantRepository;

    public UserServiceImpl(UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);


    }

    @Override
    public void assignFavRestaurantToUser(long userId, long restaurantId) {
        User user = userRepository.findById(userId).get();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        user.getFavRestaurants().add(restaurant);
        restaurant.getUsersFav().add(user);

        userRepository.save(user);
        restaurantRepository.save(restaurant);


    }

    @Override
    public void removeFavRestaurantFromUser(long userId, long restaurantId) {
        User user = userRepository.findById(userId).get();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        user.getFavRestaurants().remove(restaurant);
        restaurant.getUsersFav().remove(user);

        userRepository.save(user);
        restaurantRepository.save(restaurant);
    }
}
















