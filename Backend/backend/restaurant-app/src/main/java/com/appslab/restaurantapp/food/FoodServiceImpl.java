package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import com.appslab.restaurantapp.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService{

    FoodRepository foodRepository;
    RestaurantRepository restaurantRepository;
    UserRepository userRepository;
    UserService userService;


    @Override
    public void addFood(Food food, Principal principal) throws GenericException {
        food.setRestaurantId(restaurantRepository.findByAdminId(userService.getCurrentUser().getId()).get().getId());
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
