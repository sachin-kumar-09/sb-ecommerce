package com.ecommerce.services;

import com.ecommerce.models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public String createCategory(Category category);
    public Category updateCategory(Category category, Long categoryId);
    public String deleteCategory(Long categoryId);
}
