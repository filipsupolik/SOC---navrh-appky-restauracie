package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.food.Food;

public interface OrderService {
    void addOrder(Order order);
    void changeStateOfOrder(long orderId, boolean completed);
}
