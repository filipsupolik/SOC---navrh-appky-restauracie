package com.appslab.restaurantapp.food;

import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{

    FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void removeFood(String foodName) {
        foodRepository.delete(foodRepository.findFoodByFoodName(foodName));
    }
}
