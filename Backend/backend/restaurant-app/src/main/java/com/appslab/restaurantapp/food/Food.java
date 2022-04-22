package com.appslab.restaurantapp.food;

import com.appslab.restaurantapp.category.Category;
import com.appslab.restaurantapp.order.Order;
import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Food {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String foodName;
    private double price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="restaurant_id", nullable=false, insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "restaurant_id")
    private long restaurantId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="category_id", nullable=false, insertable = false, updatable = false)
    private Category category;

    @Column(name = "category_id")
    private long categoryId;

    @OneToMany(mappedBy="orderedFood")
    private Set<Order> orders;

    public Food() {
    }

    public Food(String foodName, long categoryId, double price) {
        this.foodName = foodName;
        this.categoryId = categoryId;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
