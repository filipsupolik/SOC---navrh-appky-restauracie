package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.order.Order;
import com.appslab.restaurantapp.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String email;
    private String address;


    @OneToMany(mappedBy="adminUser")
    private Set<Restaurant> adminOfRestaurants;

    @OneToMany(mappedBy="userAdmin")
    private Set<Order> orders;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders2;


    public User() {
    }

    public User(String username, String password, String email, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Restaurant> getAdminOfRestaurants() {
        return adminOfRestaurants;
    }

    public void setAdminOfRestaurants(Set<Restaurant> adminOfRestaurants) {
        this.adminOfRestaurants = adminOfRestaurants;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
