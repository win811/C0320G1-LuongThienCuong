package com.example.cart.repositories.Impl;

import com.example.cart.models.Product;
import com.example.cart.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Long,Product> products;
    static {
        products=new HashMap<>();
        products.put(1L,new Product(1L,"Iphone11","Apple",2000.0));
        products.put(2L,new Product(2L,"Samsung galaxy s9","Samsung",500.0));
        products.put(3L,new Product(3L,"Ipad pro","Apple",1000.0));
        products.put(4L,new Product(4L,"Xiaomi note me","Xiaomi",300.0));
        products.put(5L,new Product(5L,"Opple A37","Opple",200.0));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }
}
