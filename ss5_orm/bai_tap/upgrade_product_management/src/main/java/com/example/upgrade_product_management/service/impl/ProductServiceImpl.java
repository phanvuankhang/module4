package com.example.upgrade_product_management.service.impl;

import com.example.upgrade_product_management.model.Product;
import com.example.upgrade_product_management.repository.IProductRepository;
import com.example.upgrade_product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
       return productRepository.save(product);
    }

    @Override
    public boolean edit(Product product) {
       return productRepository.edit(product);
    }

    @Override
    public boolean delete(int id) {
        Product product = findById(id);
       return productRepository.delete(product);
    }

    @Override
    public List<Product> search(String search) {
        return productRepository.search(search);
    }
}
