package com.example.upgrade_product_management.service;


import com.example.upgrade_product_management.model.Product;


import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean edit(Product product);
    boolean delete(int id);
    List<Product> search(String search);
}
