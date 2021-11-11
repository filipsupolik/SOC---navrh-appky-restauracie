package com.appslab.restaurantapp.food;


import com.appslab.restaurantapp.exception.GenericException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
