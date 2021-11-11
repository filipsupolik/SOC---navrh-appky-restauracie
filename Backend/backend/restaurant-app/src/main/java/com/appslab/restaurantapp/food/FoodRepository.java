package com.appslab.restaurantapp.food;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository <Food, Long> {
    Food findFoodByFoodName(String foodName);
    List<Food> findAllFoodByCategory(String category);

}
