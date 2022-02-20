package com.appslab.restaurantapp.food;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository <Food, Long> {
    Food findFoodByFoodName(String foodName);
    List<Food> findAllFoodByCategoryId(Long categoryId);
    List<Food> findAllFoodByRestaurantId(Long restaurantId);
    Food findFoodById(Long foodId);

}
