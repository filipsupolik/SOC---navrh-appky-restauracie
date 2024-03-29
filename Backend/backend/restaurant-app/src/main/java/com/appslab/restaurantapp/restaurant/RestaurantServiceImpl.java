package com.appslab.restaurantapp.restaurant;

import com.appslab.restaurantapp.category.Category;
import com.appslab.restaurantapp.category.CategoryRepository;
import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantRepository restaurantRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    UserService userService;


    @Override
    public void createRestaurant(Restaurant restaurant, Principal principal) throws GenericException {
        if (restaurantRepository.findByAdminId(userService.getCurrentUser().getId()).isEmpty()||userRepository.findByUsername(principal.getName()).get().getId()==1){
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
    public List<Restaurant> getRestaurantsByCategory(String categoryName) {
        return this.categoryRepository.findCategoryByName(categoryName)
                .map(Category::getFood)
                .map(Collection::stream)
                .map(foodStream -> foodStream.map(Food::getRestaurant))
                .map(Stream::distinct)
                .map(foodStream -> foodStream.collect(Collectors.toList()))
                .orElse(new ArrayList<>());
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
            if(time.isAfter(restaurant.getOpeningTime().minusMinutes(10))&&time.isBefore(restaurant.getClosingTime().minusMinutes(10))){
                filteredRestaurants.add(restaurant);
            }

        }


        return filteredRestaurants;
    }

    @Override
    public List<Restaurant> getRestaurantsByRegion(Restaurant.Region region) {
        return restaurantRepository.findByRegion(region);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    @Override
    public Restaurant getCurrentUsersRestaurant() {
        return restaurantRepository.findRestaurantById(userService.getCurrentUser().getAdminOfRestaurant().getId());
    }

}
