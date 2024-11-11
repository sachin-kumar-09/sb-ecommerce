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
        List<Category> categories = categoryRepository.findAll();
        if(categories == null || categories.isEmpty()) {
            throw new APIException("No categories found.");
        }
    }

    @Override
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());

        if(savedCategory != null) {
        }

    }

    @Override
        Category savedCategory = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        category.setCategoryID(categoryId);
        savedCategory = categoryRepository.save(category);

    }

    @Override
        categoryRepository.deleteById(categoryId);
    }
}
