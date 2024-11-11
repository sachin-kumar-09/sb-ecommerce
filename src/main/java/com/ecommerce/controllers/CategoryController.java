package com.ecommerce.controllers;

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
    }

    @PostMapping("/admin/category")
    }

    @PutMapping("/admin/categories/{categoryId}")
    }

    @DeleteMapping("/admin/categories/{categoryId}")
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
