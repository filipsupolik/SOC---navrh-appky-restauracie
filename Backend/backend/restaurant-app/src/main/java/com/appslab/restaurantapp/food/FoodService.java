package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.exception.GenericException;

import java.security.Principal;
import java.util.List;

public interface FoodService {

    void addFood(Food food, Principal principal) throws GenericException;
    void removeFood(Long foodId, Principal principal) throws GenericException;
    List<Food> getMenu(Long restaurantId);
    List<String> getCategories();
}
