package com.nimap_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap_task.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
