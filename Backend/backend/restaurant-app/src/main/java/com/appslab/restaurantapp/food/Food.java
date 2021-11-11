package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Food {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String foodName;
    private String category;

    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false, insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "restaurant_id")
    private long restaurantId;


    public Food() {
    }

    public Food(String foodName, String category, Restaurant restaurant) {
        this.foodName = foodName;
        this.category = category;
        this.restaurant = restaurant;
    }

    public Food(String foodName, long restaurantId) {
        this.foodName = foodName;
        this.restaurantId = restaurantId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
