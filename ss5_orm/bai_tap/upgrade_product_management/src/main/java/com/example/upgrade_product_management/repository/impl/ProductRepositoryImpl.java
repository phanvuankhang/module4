package com.example.upgrade_product_management.repository.impl;

import com.example.upgrade_product_management.model.Product;
import com.example.upgrade_product_management.repository.BaseRepository;
import com.example.upgrade_product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList= BaseRepository.entityManager.createQuery("SELECT p FROM Product p ",Product.class).getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product=BaseRepository.entityManager.find(Product.class,id);
        return product;
    }

    @Override
    public boolean save(Product product) {
        EntityTransaction transaction=BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
        return true;
    }

    @Override
    public boolean edit(Product product) {
        EntityTransaction transaction=BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Product product) {
        EntityTransaction transaction=BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(product);
        transaction.commit();
        return true;
    }

    @Override
    public List<Product> search(String search) {
        List<Product> productList=BaseRepository.entityManager.createQuery("SELECT p FROM Product p WHERE p.name LIKE :search").setParameter("search","%"+search.trim()+"%").getResultList();
        return productList;
    }
}
