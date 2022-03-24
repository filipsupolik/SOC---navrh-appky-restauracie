package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.food.Food;

import java.util.List;

public interface OrderService {
    void addOrder(long orderedFoodId);
    void changeStateOfOrder(long orderId, boolean completed);
    List<Order> getOrdersByAdminId(long adminId);
}
