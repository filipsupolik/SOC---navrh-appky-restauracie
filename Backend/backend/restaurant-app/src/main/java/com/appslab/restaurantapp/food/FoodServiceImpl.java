package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    FoodRepository foodRepository;
    RestaurantRepository restaurantRepository;
    UserRepository userRepository;


    public FoodServiceImpl(FoodRepository foodRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addFood(Food food, Principal principal) throws GenericException {
        Restaurant restaurant = restaurantRepository.findRestaurantById(food.getRestaurantId());
        User user = userRepository.findUserById(restaurant.getAdminId());
        if(userRepository.findByUsername(principal.getName()).get().getId()==user.getId()){
            foodRepository.save(food);
        }
        else{
            throw new GenericException("You are not authorised to edit this restaurant");
        }



    }

    @Override
    public void removeFood(Long foodId, Principal principal) throws GenericException{
        Food food = foodRepository.findFoodById(foodId);
        Restaurant restaurant = restaurantRepository.findRestaurantById(food.getRestaurantId());
        User user = userRepository.findUserById(restaurant.getAdminId());
        if(userRepository.findByUsername(principal.getName()).get().getId()==user.getId()){
            foodRepository.delete(foodRepository.findFoodById(foodId));
        }
        else{
            throw new GenericException("You are not authorised to edit this restaurant");
        }


    }

    @Override
    public List<Food> getMenu(Long restaurantId) {
        return foodRepository.findAllFoodByRestaurantId(restaurantId);
    }



}
