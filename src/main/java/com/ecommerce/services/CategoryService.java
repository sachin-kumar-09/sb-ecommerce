package com.ecommerce.services;

import com.ecommerce.dtos.request.CategoryRequest;
import com.ecommerce.dtos.response.CategoryResponse;
import com.ecommerce.models.Category;

import java.util.List;

public interface CategoryService {
    public CategoryResponse getCategories(int pageNumer, int pageSize);
    public CategoryRequest createCategory(CategoryRequest categoryRequest);
    public CategoryRequest updateCategory(CategoryRequest categoryRequest, Long categoryId);
    public CategoryRequest deleteCategory(Long categoryId);
}
