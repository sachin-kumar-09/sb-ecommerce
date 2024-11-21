package com.ecommerce.controllers;

import com.ecommerce.models.Category;
import com.ecommerce.services.CategoryService;
import com.ecommerce.services.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ecommerce.models.Category;
import com.ecommerce.services.CategoryService;
import com.ecommerce.services.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
        }catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PostMapping("/admin/category")
    }

    @PutMapping("/admin/categories/{categoryId}")
    }

    @DeleteMapping("/admin/categories/{categoryId}")
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
