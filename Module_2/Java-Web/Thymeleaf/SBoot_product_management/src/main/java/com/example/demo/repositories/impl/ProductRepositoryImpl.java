package com.example.demo.repositories.impl;

import com.example.demo.models.Product;
import org.springframework.stereotype.Repository;
import com.example.demo.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer,Product> listProduct = new HashMap<>();

    static {
        listProduct.put(1,new Product(1,"Iphone 7","4.7 inches","Apple"));
        listProduct.put(2,new Product(2,"Iphone 7 plus","5.5 inches","Apple"));
        listProduct.put(3,new Product(3,"Iphone X","5.8 inches","Apple"));
        listProduct.put(4,new Product(4,"Redmi Note 8","6.3 inches","Xiaomi"));
        listProduct.put(5,new Product(5,"Vsmart Active 3","6.39 inches","Vin Group"));    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public Product getById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void deleteById(int id) {
        listProduct.remove(id);
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(),product);
    }
}
