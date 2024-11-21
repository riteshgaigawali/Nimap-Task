package com.nimap_task.serviceimpl;

import com.nimap_task.entity.Product;
import com.nimap_task.exception.ResourceNotFoundException;
import com.nimap_task.repository.ProductRepository;
import com.nimap_task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        try {
            return productRepository.findAll(pageable); // Paginated data
        } catch (Exception e) {
            throw new RuntimeException("Error fetching paginated products: " + e.getMessage(), e);
        }
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error creating product: " + e.getMessage(), e);
        }
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        try {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        } catch (Exception e) {
            throw new RuntimeException("Error updating product: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        try {
            productRepository.delete(existingProduct);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting product: " + e.getMessage(), e);
        }
    }
}
