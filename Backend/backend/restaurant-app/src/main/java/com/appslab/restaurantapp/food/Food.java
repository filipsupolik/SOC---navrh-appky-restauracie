package com.appslab.restaurantapp.food;

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



    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
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
}
