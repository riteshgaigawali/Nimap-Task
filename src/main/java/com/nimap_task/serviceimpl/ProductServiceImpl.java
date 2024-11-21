package com.nimap_task.serviceimpl;

import com.nimap_task.entity.Category;
import com.nimap_task.entity.Product;
import com.nimap_task.exception.ResourceNotFoundException;
import com.nimap_task.repository.CategoryRepository;
import com.nimap_task.repository.ProductRepository;
import com.nimap_task.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        // Ensure category exists in the database
        long categoryId = product.getCategory().getCatId();
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        // Set the managed category object
        product.setCategory(existingCategory);

        // Save product
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(long id, Product productDetails) throws ResourceNotFoundException {
        // Fetch the existing product
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        // Update product details
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());

        // Handle the category update
        if (productDetails.getCategory() != null && productDetails.getCategory().getCatId() != null) {
            long categoryId = productDetails.getCategory().getCatId();
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
            existingProduct.setCategory(category);
        }

        // Save and return the updated product
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(long id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        productRepository.delete(product);
    }
}
