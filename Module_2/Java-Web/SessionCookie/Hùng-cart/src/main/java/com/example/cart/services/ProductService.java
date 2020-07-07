package com.example.cart.services;

import com.example.cart.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    Product findProductById(Long id);
    void saveProduct(Product product);
    void deleteProductById(Long id);
}
