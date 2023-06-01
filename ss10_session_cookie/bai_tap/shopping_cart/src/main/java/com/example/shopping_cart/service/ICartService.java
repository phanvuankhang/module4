package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;

import java.util.Map;

public interface ICartService {
    boolean checkExits(Product product, Map<Product, Integer> productIntegerMap);

    Map.Entry<Product, Integer> productIntegerEntry(Product product, Map<Product, Integer> productIntegerMap);

    Double getTotal(Map<Product, Integer> productIntegerMap);
}
