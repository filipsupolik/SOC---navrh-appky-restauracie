package com.appslab.restaurantapp;

import com.appslab.restaurantapp.category.Category;
import com.appslab.restaurantapp.category.CategoryRepository;
import com.appslab.restaurantapp.category.CategoryService;
import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DefaultInitialization implements CommandLineRunner {

    UserService userService;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    CategoryService categoryService;
    CategoryRepository categoryRepository;



    @Override
    public void run(String... args) throws Exception {
        User user = new User("admin","password","admin@admin.admin", "Adminova 11, Bratislava");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userService.getUserByUsername("admin").isEmpty()==true) {
            userService.createUser(user);
        }

        Category pizza = new Category("Pizza");
        Category burger = new Category("Burger");
        Category noodles = new Category("Noodles");
        Category sandwiches = new Category("Sandwiches");
        Category breakfast = new Category("Breakfast");
        Category steak = new Category("Steak");

        if (categoryRepository.findCategoryByName("pizza").isEmpty()==true){
            categoryService.addCategory(pizza);
            categoryService.addCategory(burger);
            categoryService.addCategory(noodles);
            categoryService.addCategory(sandwiches);
            categoryService.addCategory(breakfast);
            categoryService.addCategory(steak);
        }




    }
}
