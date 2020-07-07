package com.example.cart.services.Impl;

import com.example.cart.models.Product;
import com.example.cart.repositories.ProductRepository;
import com.example.cart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void deleteProductById(Long id) {

    }
}
