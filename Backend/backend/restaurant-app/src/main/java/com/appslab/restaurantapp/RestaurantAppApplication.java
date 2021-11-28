package com.appslab.restaurantapp;

import com.appslab.restaurantapp.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class RestaurantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantAppApplication.class, args);
		System.out.println("App is running");

	}

}
