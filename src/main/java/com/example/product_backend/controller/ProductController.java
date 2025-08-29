package com.example.product_backend.controller;

import com.example.product_backend.model.Product;
import com.example.product_backend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET /admin/products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAll();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    // POST /admin/products
    @PostMapping("/products")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(service.add(product));
    }

    // DELETE /admin/products/{id}
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /admin/products/{id}
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /admin/low-stock
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> getLowStockProducts() {
        List<Product> lowStock = service.getLowStockProducts(5); // threshold = 5
        if (lowStock.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lowStock);
    }
}