package com.example.upgrade_product_management.repository;

import com.example.upgrade_product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean edit(Product product);
    boolean delete(Product product);
    List<Product> search(String search);
}
