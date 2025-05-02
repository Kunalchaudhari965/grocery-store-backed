package com.example.grocerystorebacked.Controller;

import com.example.grocerystorebacked.Model.Product;
import com.example.grocerystorebacked.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*") // allow frontend access
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/getbyid/{id}")
    public Product getById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable UUID id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
