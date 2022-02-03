package com.appslab.restaurantapp.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findOrderById(long orderId);
}
