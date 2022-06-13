package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.exception.GenericException;
import com.appslab.restaurantapp.restaurant.Restaurant;
import com.appslab.restaurantapp.restaurant.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RestaurantRepository restaurantRepository;


    @Override
    public void createUser(User user) throws GenericException {
        List<User> users = (List<User>) userRepository.findAll();

        if(users.stream()
                .anyMatch(user1 -> user1.getUsername().equals(user.getUsername()))){
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
        return userRepository.findByUsername(name).orElse(null);
    }
}

















