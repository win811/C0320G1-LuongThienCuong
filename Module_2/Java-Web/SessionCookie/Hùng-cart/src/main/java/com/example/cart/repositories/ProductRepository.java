package com.example.cart.repositories;

import com.example.cart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
