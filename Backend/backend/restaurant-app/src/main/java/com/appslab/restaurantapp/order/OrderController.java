package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.food.Food;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/addOrder")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @PostMapping(value = "/changeStateOfOrder")
    public void changeStateOfOrder(@RequestParam long orderId, @RequestParam boolean completed){
        orderService.changeStateOfOrder(orderId, completed);
    }
}
