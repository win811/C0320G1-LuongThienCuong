package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    List<Product> findByName(String name);
    void save(Product product);
    void update(int id,String name,String description,String manufacturer);
    void remove(int id);
}
