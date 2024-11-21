package com.nimap_task.service;

import com.nimap_task.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable); // Paginated method

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
