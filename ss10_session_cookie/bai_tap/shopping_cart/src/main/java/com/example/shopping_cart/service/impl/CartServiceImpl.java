package com.example.shopping_cart.service.impl;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.IProductRepository;
import com.example.shopping_cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements ICartService {
    @Override
    public boolean checkExits(Product product, Map<Product, Integer> productIntegerMap) {
        for (Map.Entry<Product, Integer> m : productIntegerMap.entrySet()) {
            if (m.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map.Entry<Product, Integer> productIntegerEntry(Product product, Map<Product, Integer> productIntegerMap) {
        for (Map.Entry<Product, Integer> m : productIntegerMap.entrySet()) {
            if (m.getKey().getId().equals(product.getId())) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Double getTotal(Map<Product, Integer> productIntegerMap) {
        double sum = 0;
        for (Map.Entry<Product, Integer> m : productIntegerMap.entrySet()) {
            sum = sum + m.getKey().getPrice() * m.getValue();
        }
        return sum;
    }
}
