package com.nimap_task.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.nimap_task.entity.Category;
import com.nimap_task.entity.Product;
import com.nimap_task.repository.CategoryRepository;
import com.nimap_task.repository.ProductRepository;

@Component
@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initData(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            // Creating Categories
            Category electronics = categoryRepository.save(new Category("Electronics"));
            Category books = categoryRepository.save(new Category("Books"));
            Category clothing = categoryRepository.save(new Category("Clothing"));
            Category homeAppliances = categoryRepository.save(new Category("Home Appliances"));
            Category sports = categoryRepository.save(new Category("Sports"));

            // Creating Products
            productRepository.save(new Product("Smartphone", 699.99, electronics));
            productRepository.save(new Product("Laptop", 999.99, electronics));
            productRepository.save(new Product("Tablet", 499.99, electronics));

            productRepository.save(new Product("Novel: The Great Gatsby", 14.99, books));
            productRepository.save(new Product("Educational Book: Data Structures", 29.99, books));

            productRepository.save(new Product("T-Shirt", 19.99, clothing));
            productRepository.save(new Product("Jeans", 49.99, clothing));

            productRepository.save(new Product("Microwave Oven", 199.99, homeAppliances));
            productRepository.save(new Product("Vacuum Cleaner", 149.99, homeAppliances));

            productRepository.save(new Product("Football", 24.99, sports));
            productRepository.save(new Product("Tennis Racket", 89.99, sports));
        };
    }
}
