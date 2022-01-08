package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;

import java.util.List;

public interface FoodService {

    void addFood(Food food) throws GenericException;
    void removeFood(String foodName);
    List<Food> getMenu(Long restaurantId);
}
