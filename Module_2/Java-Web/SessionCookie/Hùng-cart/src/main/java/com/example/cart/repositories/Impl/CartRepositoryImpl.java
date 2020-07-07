package com.example.cart.repositories.Impl;

import com.example.cart.models.Product;
import com.example.cart.repositories.CartRepository;

import java.util.HashMap;
import java.util.Map;

public class CartRepositoryImpl  implements CartRepository {
    private static Map<Integer,Product> cartList = new HashMap<>();
    @Override
    public Map<Integer, Product> findAll() {
        return cartList;
    }

    @Override
    public void addToCart(Integer number,Product product) {
        cartList.put(number,product);
    }
}
