package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RestaurantRepository restaurantRepository;

    public UserServiceImpl(UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void createUser(User user) throws GenericException {

        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new GenericException("Username is already taken");
        }
        else{
            userRepository.save(user);
        }

    }

    @Override
    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User getCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(name).orElseThrow();
    }
}

















