package com.appslab.restaurantapp.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private long id;
    private boolean completed;
    private double price;
    private String address;
    private long restaurantAdminId;
    private long orderedFoodId;
    private long customerId;
    private boolean ordered;

    public OrderDTO(long id, boolean completed, double price, String address, long restaurantAdminId, long orderedFoodId, long customerId, boolean ordered) {
        this.id = id;
        this.completed = completed;
        this.price = price;
        this.address = address;
        this.restaurantAdminId = restaurantAdminId;
        this.orderedFoodId = orderedFoodId;
        this.customerId = customerId;
        this.ordered = ordered;
    }
}
