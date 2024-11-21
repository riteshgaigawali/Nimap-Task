package com.nimap_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap_task.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
