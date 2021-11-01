package com.appslab.restaurantapp.food;


import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository <Food, Long> {
    Food findFoodByFoodName(String foodName);

}
