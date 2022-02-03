package com.appslab.restaurantapp.user;

import com.appslab.restaurantapp.exception.GenericException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface UserService {

    void createUser(User user)throws GenericException;
    Optional<User> getUserByUsername(String username);
    User getCurrentUser();

}
