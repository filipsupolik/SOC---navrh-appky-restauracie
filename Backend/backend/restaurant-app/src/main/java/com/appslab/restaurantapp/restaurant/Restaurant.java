package com.appslab.restaurantapp.restaurant;


import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;
import java.security.Principal;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String restaurantName;
    private String description;
    private int deliveryTimeMinutes;
    private String openingTime;
    private String address;

    @JsonIgnore
    @ManyToMany(mappedBy = "favRestaurants", cascade = CascadeType.ALL)
    Set<User> usersFav;

    @OneToMany(mappedBy="restaurant")
    private Set<Food> food;

    @ManyToOne
    @JoinColumn(name="adminId", nullable=false, insertable = false, updatable = false)
    private User adminUser;

    @Column(name = "adminId")
    private long adminId;

    public Restaurant() {
    }

    public Restaurant(long id, String restaurantName, String description, int deliveryTime, String openingTime, String address) {       //constructor for tests
        this.id = id;
        this.restaurantName = restaurantName;
        this.description = description;
        this.deliveryTimeMinutes = deliveryTime;
        this.openingTime = openingTime;
        this.address = address;
    }

    public Restaurant(String restaurantName, String description, int deliveryTime, String openingTime, String address, Long adminId) {
        this.restaurantName = restaurantName;
        this.description = description;
        this.deliveryTimeMinutes = deliveryTime;
        this.openingTime = openingTime;
        this.address = address;
        this.adminId = adminId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDeliveryTimeMinutes() {
        return deliveryTimeMinutes;
    }

    public void setDeliveryTimeMinutes(int deliveryTimeMinutes) {
        this.deliveryTimeMinutes = deliveryTimeMinutes;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }
}
