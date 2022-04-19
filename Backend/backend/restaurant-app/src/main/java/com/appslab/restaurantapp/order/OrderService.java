package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.dto.OrderDTO;
import com.appslab.restaurantapp.food.Food;

import java.util.List;

public interface OrderService {
    void addOrder(long orderedFoodId);
    void changeStateOfOrder(long orderId);
    void sendFoodOrder();
    List<OrderDTO> getRestaurantsOrders();
    List<OrderDTO> getAllUsersOrders();
}
