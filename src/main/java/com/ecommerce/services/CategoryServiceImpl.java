package com.ecommerce.services;

import com.ecommerce.exceptions.APIException;
import com.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.models.Category;
import com.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories == null || categories.isEmpty()) {
            throw new APIException("No categories found.");
        }
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());

        if(savedCategory != null) {
            throw new APIException("Category with name: " + category.getCategoryName() + " already exist.");
        }

        categoryRepository.save(category);
        return "category inserted successfully.";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryID(categoryId);
        savedCategory = categoryRepository.save(category);

        return savedCategory;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        if(categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return "category removed successfully.";
        }

        throw new ResourceNotFoundException("Category", "categoryId", categoryId);
    }
}
