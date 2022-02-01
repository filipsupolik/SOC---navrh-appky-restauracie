package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.food.FoodRepository;
import com.appslab.restaurantapp.user.User;
import com.appslab.restaurantapp.user.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    FoodRepository foodRepository;
    UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, FoodRepository foodRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addOrder(Order order) {
        order.setPrice(foodRepository.findFoodById(order.getOrderedFoodId()).getPrice());
        order.setAddress(userRepository.findUserById(order.getCustomerId()).getAddress());
        order.setCompleted(false);
        orderRepository.save(order);
    }
}
