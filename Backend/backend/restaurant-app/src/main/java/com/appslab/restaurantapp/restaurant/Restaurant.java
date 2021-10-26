package com.appslab.restaurantapp.restaurant;


import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String restaurantName;


    @ManyToMany(mappedBy = "favRestaurants", cascade = CascadeType.ALL)
    Set<User> usersFav;




    public Restaurant() {
    }

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Set<User> getUsersFav() {
        return usersFav;
    }

    public void setUsers(Set<User> usersFav) {
        this.usersFav = usersFav;
    }
}
