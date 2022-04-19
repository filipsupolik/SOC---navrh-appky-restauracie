package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.category.Category;
import com.appslab.restaurantapp.category.CategoryRepository;
import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantRepository restaurantRepository;
    FoodRepository foodRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;


    @Override
    public void createRestaurant(Restaurant restaurant, Principal principal) throws GenericException {
        if (userRepository.findByUsername(principal.getName()).get().getAdminOfRestaurants().isEmpty()||userRepository.findByUsername(principal.getName()).get().getId()==1){
            if(restaurantRepository.findByRestaurantName(restaurant.getRestaurantName()).isPresent()){
                throw new GenericException("Restaurant name is already taken");
            }
            else{
                restaurant.setAdminId(userRepository.findByUsername(principal.getName()).get().getId());
                restaurantRepository.save(restaurant);
            }
        }
        else
            throw new GenericException("Only 1 restaurant per user!");

    }

    @Override
    public List<Restaurant> getRestaurantsByCategory(String category) {
        Optional<Category> category1 = categoryRepository.findCategoryByName(category);
        List<Food> foods = foodRepository.findAllFoodByCategoryId(category1.get().getId());
        List<Restaurant> restaurants = new ArrayList<>();

        for (int i=0;i<foods.size();i++){
            restaurants.add(restaurantRepository.findById(foods.get(i).getRestaurantId()).get());
        }
        return restaurants;
    }

    @Override
    public Optional<Restaurant> getRestaurantById(long id) {
        return this.restaurantRepository.findById(id);
    }

    @Override
    public Restaurant getRestaurantInfo(Long restaurantId) {
        return restaurantRepository.findRestaurantById(restaurantId);
    }

    @Override
    public List<Restaurant> getRestaurantsByTime(LocalTime time) {
        List<Restaurant> allRestaurants = (List<Restaurant>) restaurantRepository.findAll();
        List<Restaurant> filteredRestaurants = new ArrayList<>();
        for (int i = 0; i < allRestaurants.size(); i++){
            Restaurant restaurant = allRestaurants.get(i);
            if(time.isAfter(restaurant.getOpeningTime())&&time.isBefore(restaurant.getClosingTime())){
                filteredRestaurants.add(restaurant);
            }

        }


        return filteredRestaurants;
    }

    @Override
    public List<Restaurant> getRestaurantsByRegion(Restaurant.Region region) {
        return restaurantRepository.findByRegion(region);
    }


}
