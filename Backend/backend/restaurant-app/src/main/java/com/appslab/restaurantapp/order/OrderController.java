package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

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
    public void changeStateOfOrder(@RequestParam long orderId){
        orderService.changeStateOfOrder(orderId);
    }

    @PostMapping(value = "/sendFoodOrder")
    public void sendFoodOrder(){
        orderService.sendFoodOrder();
    }

    @GetMapping(value = "/getRestaurantsOrders")
    public List<OrderDTO> getRestaurantsOrders(){
        return orderService.getRestaurantsOrders();
    }

    @GetMapping(value = "/getRestaurantsIncompleteOrders")
    public List<OrderDTO> getRestaurantsIncompleteOrders(){
        return orderService.getRestaurantsIncompleteOrders();
    }

    @GetMapping(value = "/getAllUsersOrders")
    public List<OrderDTO> getAllUsersOrders(){
        return orderService.getAllUsersOrders();
    }

    @PostMapping(value = "/deleteOrder")
    public void deleteOrder(@RequestParam long orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping(value = "/getOrdersForShoppingCart")
    public List<OrderDTO> getOrdersForShoppingCart(){
        return orderService.getOrdersForShoppingCart();
    }


}
