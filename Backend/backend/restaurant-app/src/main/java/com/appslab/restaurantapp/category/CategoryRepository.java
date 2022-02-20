package com.appslab.restaurantapp.category;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryById(Long categoryId);
    Optional<Category> findCategoryByName(String categoryName);
}
