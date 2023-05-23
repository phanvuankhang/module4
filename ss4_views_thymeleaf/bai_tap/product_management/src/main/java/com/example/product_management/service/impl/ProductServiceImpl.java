package com.example.product_management.service.impl;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "FordTuner", 2000d, "Xe SUV 7 chỗ", "Toyota"));
        productList.add(new Product(2, "Ford Everest", 4000d, "Xe SUV 5 chỗ", "Ford"));
        productList.add(new Product(3, "C300", 5000d, "Xe sedan", "Mercedes"));
        productList.add(new Product(4, "CX-5", 1000d, "Xe SUV 5 chỗ", "Mazda"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return  productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(Product product, int id) {
        Product findProduct=findById(id);
        int index=productList.indexOf(findProduct);
        productList.set(index,product);
    }

    @Override
    public void delete(int id) {
        Product findProduct=findById(id);
        productList.remove(findProduct);
    }

    @Override
    public List<Product> search(String search) {
        List<Product> findListProduct=new ArrayList<>();
        for (Product p:productList) {
          if (p.getName().toLowerCase().contains(search.toLowerCase())){
              findListProduct.add(p);
          }
        }
        return findListProduct;
    }
}
