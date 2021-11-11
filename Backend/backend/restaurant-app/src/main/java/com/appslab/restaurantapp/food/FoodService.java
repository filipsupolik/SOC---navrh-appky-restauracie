package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;

public interface FoodService {

    public void addFood(Food food) throws GenericException;
    public void removeFood(String foodName);
}
