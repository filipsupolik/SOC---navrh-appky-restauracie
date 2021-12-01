package com.appslab.restaurantapp.registration;

import com.appslab.restaurantapp.security.MyUserDetailsService;
import com.appslab.restaurantapp.user.AppUserRole;
import com.appslab.restaurantapp.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final MyUserDetailsService myUserDetailsService;

    public String register(RegistrationRequest request){
        return myUserDetailsService.signUpUser(new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
                ));
    }
}
