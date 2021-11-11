package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;

public interface FoodService {

    void addFood(Food food) throws GenericException;
    void removeFood(String foodName);
}
