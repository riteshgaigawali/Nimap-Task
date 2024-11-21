package com.nimap_task.service;

import com.nimap_task.entity.Product;
import com.nimap_task.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product createProduct(Product product);

    Page<Product> getAllProducts(int page, int size);

    Product getProductById(long id) throws ResourceNotFoundException;

    Product updateProduct(long id, Product productDetails) throws ResourceNotFoundException;

    void deleteProduct(long id) throws ResourceNotFoundException;
}
