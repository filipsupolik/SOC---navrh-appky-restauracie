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
        orderRepository.save(order);
    }

    @Override
    public void changeStateOfOrder(long orderId, boolean completed) {
        Order order = orderRepository.findOrderById(orderId);
        order.setCompleted(completed);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDTO> getOrdersByAdminId(long adminId) {
        List<Order> orders = orderRepository.findOrdersByRestaurantAdminId(adminId);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(int i = 0;i<orders.size();i++) {

            OrderDTO orderDTO = new OrderDTO(orders.get(i).getId(), orders.get(i).isCompleted(), orders.get(i).getPrice(), orders.get(i).getAddress(), orders.get(i).getRestaurantAdminId(), orders.get(i).getOrderedFoodId(), orders.get(i).getCustomerId());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
}
