package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(int id);
    void deleteProductById(int id);
    void saveProduct(Product product);
}
