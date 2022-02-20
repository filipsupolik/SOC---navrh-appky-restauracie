package com.appslab.restaurantapp.category;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.food.Food;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class CategoryController {

    CategoryService categoryService;

    @PostMapping(value = "/addCategory")
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    @GetMapping(value = "/getCategoryById")
    public Category getCategoryById(@RequestParam Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping(value = "/getCategoryByName")
    public Optional<Category> getCategoryByName(@RequestParam String categoryName){
        return categoryService.getCategoryByName(categoryName);
    }

    @GetMapping(value = "/getAllCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
