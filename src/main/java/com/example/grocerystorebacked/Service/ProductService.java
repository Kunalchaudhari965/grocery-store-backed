package com.example.grocerystorebacked.Service;
import com.example.grocerystorebacked.Model.Product;
import com.example.grocerystorebacked.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(UUID id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setCategory(updatedProduct.getCategory());
        existing.setPrice(updatedProduct.getPrice());
        existing.setStock(updatedProduct.getStock());
        existing.setImageUrl(updatedProduct.getImageUrl());
        existing.setAvailable(updatedProduct.isAvailable());
        existing.setRating(updatedProduct.getRating());
        return productRepository.save(existing);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}

