package com.example.product_backend.service;

import com.example.product_backend.model.Product;
import com.example.product_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getLowStockProducts(int threshold) {
        return getAll().stream()
            .filter(p -> p.getquantity() < threshold)
            .toList();
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
}