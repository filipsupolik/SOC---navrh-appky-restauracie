package com.appslab.restaurantapp.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void addCategory(Category category);
    Category getCategoryById(long categoryId);
    List<Category> getAllCategories();
    Optional<Category> getCategoryByName(String categoryName);
}
