package com.example.cart.repositories;

import com.example.cart.models.Product;

import java.util.Map;

public interface CartRepository {
    Map<Integer, Product> findAll();
    void addToCart(Integer number,Product product);
}
