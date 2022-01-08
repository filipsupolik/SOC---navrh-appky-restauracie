package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class FoodRepositoryTest {

    @Autowired
    private FoodRepository underTest;

    @Autowired
    private RestaurantRepository restaurantRepository;

    Restaurant restaurant = new Restaurant(1, "UTehotnehoPsa", "great restaurant", 20, "Po-Ne 13:30-21:00", "Hulvata 25, 546 32 Bratislava");

    @Test
    void itShouldFindFoodByFoodName() {
        //given
        restaurantRepository.save(restaurant);

        String name = "Burger";
        Food food = new Food(name, "Burger", 1);
        underTest.save(food);

        //when
        Food expected = underTest.findFoodByFoodName(name);

        //then
        assertThat(expected).isEqualTo(food);

    }

    @Test
    void ItShouldFindAllFoodByCategory() {
        //given
        restaurantRepository.save(restaurant);

        String category = "Burger";
        Food food1 = new Food("Burger", category, 1);
        Food food2 = new Food("ChickenBurger", category, 1);
        underTest.save(food1);
        underTest.save(food2);

        List<Food> food = new ArrayList<>();
        food.add(food1);
        food.add(food2);

        //when
        List<Food> expected = underTest.findAllFoodByCategory(category);

        //then
        assertThat(expected).isEqualTo(food);

    }
}