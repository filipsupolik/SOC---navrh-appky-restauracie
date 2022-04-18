package com.appslab.restaurantapp.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findOrderById(long orderId);
    List<Order> findOrdersByRestaurantAdminId(long restaurantAdminId);
    List<Order> findOrdersByCustomerId(long customerId);
}
