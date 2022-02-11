package com.appslab.restaurantapp.food;


import com.appslab.restaurantapp.exception.GenericException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class FoodController {

    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping(value = "/addFood")
    public void addFood(@RequestBody Food food, Principal principal)throws GenericException {
        foodService.addFood(food, principal);
    }

    @PostMapping(value = "/deleteFood")
    public void deleteFood(@RequestParam Long foodId, Principal principal) throws GenericException{
        foodService.removeFood(foodId, principal);
    }

    @GetMapping(value = "/getMenu")
    public List<Food> getMenu(@RequestParam Long restaurantId){
        return foodService.getMenu(restaurantId);
    }

    @GetMapping(value = "/getCategories")
    public List<String> getCategories(){
        return foodService.getCategories();
    }

}
