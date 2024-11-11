package com.ecommerce.controllers;

import com.ecommerce.dtos.request.CategoryRequest;
import com.ecommerce.dtos.response.CategoryResponse;
import com.ecommerce.models.Category;
import com.ecommerce.services.CategoryService;
import com.ecommerce.services.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getCategories(
            @RequestParam(name = "pageNumber") int pageNumber,
            @RequestParam(name = "pageSize") int pageSize
    ) {
        return ResponseEntity.ok(categoryService.getCategories(pageNumber, pageSize));
    }

    @PostMapping("/admin/category")
    public ResponseEntity<CategoryRequest> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryRequest));
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryRequest> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest, @PathVariable Long categoryId) {
        CategoryRequest savedCategoryRequest = categoryService.updateCategory(categoryRequest, categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(savedCategoryRequest);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryRequest> deleteCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
