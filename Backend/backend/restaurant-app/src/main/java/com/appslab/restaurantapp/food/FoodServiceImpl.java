package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    FoodRepository foodRepository;


    List<String> categories = Arrays.asList(new String[] {"Pizza", "Burger", "Noodles", "Sub-sandwiches", "Chowmein", "Steak"});

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFood(Food food) throws GenericException {
        if(categories.contains(food.getCategory())==true){
            foodRepository.save(food);
        }
        else {
            throw new GenericException("Food's category is not correct");
        }

    }

    @Override
    public void removeFood(Long foodId) {
        foodRepository.delete(foodRepository.findFoodById(foodId));
    }

    @Override
    public List<Food> getMenu(Long restaurantId) {
        return foodRepository.findAllFoodByRestaurantId(restaurantId);
    }
}
