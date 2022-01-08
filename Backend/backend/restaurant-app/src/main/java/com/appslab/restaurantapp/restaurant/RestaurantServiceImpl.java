package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantRepository restaurantRepository;
    FoodRepository foodRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, FoodRepository foodRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
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
    public Restaurant getRestaurantInfo(Long restaurantId) {
        return restaurantRepository.findRestaurantById(restaurantId);
    }
}
