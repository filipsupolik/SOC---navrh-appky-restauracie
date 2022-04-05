package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.dto.OrderDTO;
import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.food.Food;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/addOrder")
    public void addOrder(@RequestParam long orderedFoodId) {
        orderService.addOrder(orderedFoodId);
    }

    @PostMapping(value = "/changeStateOfOrder")
    public void changeStateOfOrder(@RequestParam long orderId, @RequestParam boolean completed){
        orderService.changeStateOfOrder(orderId, completed);
    }

    @GetMapping(value = "/getOrdersByAdminId")
    public List<OrderDTO> getOrdersByAdminId(@RequestParam long adminId){
        return orderService.getOrdersByAdminId(adminId);
    }
}
