package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantRepository restaurantRepository;
    FoodRepository foodRepository;
    UserRepository userRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, FoodRepository foodRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createRestaurant(Restaurant restaurant, Principal principal) throws GenericException {
        if(restaurantRepository.findByRestaurantName(restaurant.getRestaurantName()).isPresent()){
            throw new GenericException("Restaurant name is already taken");
        }
        else{
        restaurant.setAdminId(userRepository.findByUsername(principal.getName()).get().getId());
        restaurantRepository.save(restaurant);
        }
    }

    @Override
    public List<Restaurant> getRestaurantsByCategory(String category) {
        List<Food> foods = foodRepository.findAllFoodByCategory(category);
        List<Restaurant> restaurants = new ArrayList<>();

        for (int i=0;i<foods.size();i++){
            restaurants.add(restaurantRepository.findById(foods.get(i).getRestaurantId()).get());
        }
        return restaurants;
    }

    @Override
    public Optional<Restaurant> getRestaurantById(long id) {
        return this.restaurantRepository.findById(id);
    }

    @Override
    public Restaurant getRestaurantInfo(Long restaurantId) {
        return restaurantRepository.findRestaurantById(restaurantId);
    }

}
