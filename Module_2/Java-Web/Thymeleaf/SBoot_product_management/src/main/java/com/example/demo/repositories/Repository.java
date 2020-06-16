package com.example.demo.repositories;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(int id);
    void deleteById(int id);
    void save(T t);
}
