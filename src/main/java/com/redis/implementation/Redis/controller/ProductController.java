package com.redis.implementation.Redis.controller;

import com.redis.implementation.Redis.entity.Product;
import com.redis.implementation.Redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/getBy/{id}")
    public Product findProductById(@PathVariable Long id){
        return productRepository.findProductById(id);
    }

    @DeleteMapping("/deleteBy/{id}")
    public String deleteById(@PathVariable Long id){
        return productRepository.deleteProductById(id);
    }
}
