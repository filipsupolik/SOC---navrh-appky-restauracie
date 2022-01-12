package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Restaurant> getRestaurantById(long id) {
        return this.restaurantRepository.findById(id);
    }
}
