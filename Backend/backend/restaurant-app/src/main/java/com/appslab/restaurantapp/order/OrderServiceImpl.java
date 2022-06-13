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
        List<Order> orders = orderRepository.findOrdersByRestaurantAdminId(userService.getCurrentUser().getId());
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(int i = 0;i<orders.size();i++) {

            OrderDTO orderDTO = new OrderDTO(orders.get(i).getId(), orders.get(i).isCompleted(), orders.get(i).getPrice(), orders.get(i).getAddress(), orders.get(i).getRestaurantAdminId(), orders.get(i).getOrderedFoodId(), orders.get(i).getCustomerId(), orders.get(i).isOrdered());
            if(orderDTO.isOrdered()){
                if (!orderDTO.isCompleted()) {
                    orderDTOS.add(orderDTO);
                }
            }

        }
        return orderDTOS;
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
        List<Order> orders = orderRepository.findOrdersByCustomerId(userService.getCurrentUser().getId());
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(int i = 0;i<orders.size();i++) {

            OrderDTO orderDTO = new OrderDTO(orders.get(i).getId(), orders.get(i).isCompleted(), orders.get(i).getPrice(), orders.get(i).getAddress(), orders.get(i).getRestaurantAdminId(), orders.get(i).getOrderedFoodId(), orders.get(i).getCustomerId(), orders.get(i).isOrdered());
            if (!orderDTO.isOrdered()){
                orderDTOS.add(orderDTO);
            }
        }
        return orderDTOS;
    }


}
