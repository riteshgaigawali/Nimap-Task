package com.nimap_task.service;

import com.nimap_task.entity.Category;
import com.nimap_task.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category createCategory(Category category);

    Page<Category> getAllCategories(int page, int size);

    Category getCategoryById(long id) throws ResourceNotFoundException;

    Category updateCategory(long id, Category categoryDetails) throws ResourceNotFoundException;

    void deleteCategory(long id) throws ResourceNotFoundException;
}
