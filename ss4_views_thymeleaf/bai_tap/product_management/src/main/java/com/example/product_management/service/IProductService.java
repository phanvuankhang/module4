package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.ui.Model;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void edit(Product product, int id);
    void delete(int id);
    List<Product> search(String search);
}
