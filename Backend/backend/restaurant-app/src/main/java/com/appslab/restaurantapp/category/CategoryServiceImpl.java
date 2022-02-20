package com.appslab.restaurantapp.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;


    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(long categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }
}
