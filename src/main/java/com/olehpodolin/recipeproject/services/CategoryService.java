package com.olehpodolin.recipeproject.services;

import com.olehpodolin.recipeproject.domain.Category;
import com.olehpodolin.recipeproject.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(String description) {
        Optional<Category> categoryOptional = categoryRepository.findByDescription(description);
        if(!categoryOptional.isPresent()) {
            throw new RuntimeException("Category not found!!!");
        }
        return categoryOptional.get();
    }

}
