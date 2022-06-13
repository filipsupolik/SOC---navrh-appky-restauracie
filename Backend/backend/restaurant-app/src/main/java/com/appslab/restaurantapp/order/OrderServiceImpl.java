package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.dto.OrderDTO;
import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import com.appslab.restaurantapp.user.UserService;
import com.appslab.restaurantapp.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    FoodRepository foodRepository;
    UserRepository userRepository;
    RestaurantRepository restaurantRepository;
    UserService userService;


    @Override
    public void addOrder(long orderedFoodId) {
        Order order = new Order();
        order.setOrderedFoodId(orderedFoodId);
        order.setRestaurantAdminId(restaurantRepository.findRestaurantById((foodRepository.findFoodById(orderedFoodId)).getRestaurantId()).getAdminId());
        order.setCustomerId(userService.getCurrentUser().getId());
        order.setPrice(foodRepository.findFoodById(order.getOrderedFoodId()).getPrice());
        order.setAddress(userRepository.findUserById(order.getCustomerId()).getAddress());
        order.setCompleted(false);
        order.setOrdered(false);
        orderRepository.save(order);
    }

    @Override
    public void changeStateOfOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        order.setCompleted(true);
        orderRepository.save(order);
    }

    @Override
    public void sendFoodOrder() {
        orderRepository.findOrdersByCustomerId(userService.getCurrentUser().getId()).stream()
                .peek(order -> order.setOrdered(true))
                .forEach(order -> orderRepository.save(order));
    }



    @Override
    public List<OrderDTO> getRestaurantsOrders() {
        return this.orderRepository.findOrdersByRestaurantAdminId(userService.getCurrentUser().getId()).stream()
                .map(order -> new OrderDTO(order.getId(), order.isCompleted(), order.getPrice(), order.getAddress(), order.getRestaurantAdminId(), order.getOrderedFoodId(), order.getCustomerId(), order.isOrdered()))
                .filter(OrderDTO::isOrdered)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getRestaurantsIncompleteOrders() {
        return this.orderRepository.findOrdersByRestaurantAdminId(userService.getCurrentUser().getId()).stream()
                .map(order -> new OrderDTO(order.getId(), order.isCompleted(), order.getPrice(), order.getAddress(), order.getRestaurantAdminId(), order.getOrderedFoodId(), order.getCustomerId(), order.isOrdered()))
                .filter(OrderDTO::isOrdered)
                .filter(orderDTO -> !orderDTO.isCompleted())
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllUsersOrders() {
        return this.orderRepository.findOrdersByCustomerId(userService.getCurrentUser().getId()).stream()
                .map(order -> new OrderDTO(order.getId(), order.isCompleted(), order.getPrice(), order.getAddress(), order.getRestaurantAdminId(), order.getOrderedFoodId(), order.getCustomerId(), order.isOrdered()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDTO> getOrdersForShoppingCart() {
        return this.orderRepository.findOrdersByCustomerId(userService.getCurrentUser().getId()).stream()
                .map(order -> new OrderDTO(order.getId(), order.isCompleted(), order.getPrice(), order.getAddress(), order.getRestaurantAdminId(), order.getOrderedFoodId(), order.getCustomerId(), order.isOrdered()))
                .filter(orderDTO -> !orderDTO.isOrdered())
                .collect(Collectors.toList());
    }


}
