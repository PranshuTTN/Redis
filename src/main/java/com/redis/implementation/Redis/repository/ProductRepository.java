package com.redis.implementation.Redis.repository;

import com.redis.implementation.Redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    public static final String hashKey = "Product";
    @Autowired
    private RedisTemplate template;

    public Product save(Product product){
        template.opsForHash().put(hashKey,product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(hashKey);
    }

    public Product findProductById(Long id){
        return (Product) template.opsForHash().get(hashKey,id);
    }

    public String deleteProductById(Long id){
        template.opsForHash().delete(hashKey,id);
        return "Product is successfully deleted";
    }
}
