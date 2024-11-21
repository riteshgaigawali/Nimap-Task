package com.nimap_task.serviceimpl;

import com.nimap_task.entity.Category;
import com.nimap_task.exception.ResourceNotFoundException;
import com.nimap_task.repository.CategoryRepository;
import com.nimap_task.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        try {
            return categoryRepository.findAll(pageable); // Paginated data
        } catch (Exception e) {
            throw new RuntimeException("Error fetching paginated categories: " + e.getMessage(), e);
        }
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
    }

    @Override
    public Category createCategory(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Error creating category: " + e.getMessage(), e);
        }
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        try {
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        } catch (Exception e) {
            throw new RuntimeException("Error updating category: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        try {
            categoryRepository.delete(existingCategory);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting category: " + e.getMessage(), e);
        }
    }
}
