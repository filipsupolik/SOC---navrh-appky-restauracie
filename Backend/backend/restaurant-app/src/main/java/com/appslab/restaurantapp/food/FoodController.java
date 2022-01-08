package com.appslab.restaurantapp.food;


import com.appslab.restaurantapp.exception.GenericException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping(value = "/addFood")
    public void addFood(@RequestBody Food food)throws GenericException {
        foodService.addFood(food);
    }

    @PostMapping(value = "/deleteFood")
    public void deleteFood(@RequestParam String foodName){
        foodService.removeFood(foodName);
    }

    @GetMapping(value = "/getMenu")
    public List<Food> getMenu(@RequestParam Long restaurantId){
        return foodService.getMenu(restaurantId);
    }

}
