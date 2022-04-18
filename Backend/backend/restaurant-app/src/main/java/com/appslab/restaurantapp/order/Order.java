package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private boolean completed;
    private double price;
    private String address;
    private boolean ordered;


    @ManyToOne
    @JoinColumn(name="restaurantAdminId", nullable=false, insertable = false, updatable = false)
    private User userAdmin;

    @Column(name = "restaurantAdminId")
    private long restaurantAdminId;


    @ManyToOne
    @JoinColumn(name="orderedFoodId", nullable=false, insertable = false, updatable = false)
    private Food orderedFood;

    @Column(name = "orderedFoodId")
    private long orderedFoodId;


    @ManyToOne
    @JoinColumn(name="customerId", nullable=false, insertable = false, updatable = false)
    private User customer;

    @Column(name = "customerId")
    private long customerId;


    public Order() {
    }


    public Order(long orderedFoodId) {
        this.orderedFoodId = orderedFoodId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(User userAdmin) {
        this.userAdmin = userAdmin;
    }

    public long getRestaurantAdminId() {
        return restaurantAdminId;
    }

    public void setRestaurantAdminId(long restaurantAdminId) {
        this.restaurantAdminId = restaurantAdminId;
    }

    public Food getOrderedFood() {
        return orderedFood;
    }

    public void setOrderedFood(Food orderedFood) {
        this.orderedFood = orderedFood;
    }

    public long getOrderedFoodId() {
        return orderedFoodId;
    }

    public void setOrderedFoodId(long orderedFoodId) {
        this.orderedFoodId = orderedFoodId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }
}
