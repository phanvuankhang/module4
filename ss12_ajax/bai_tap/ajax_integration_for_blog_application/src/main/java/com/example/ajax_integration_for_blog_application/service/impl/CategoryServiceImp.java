package com.example.ajax_integration_for_blog_application.service.impl;


import com.example.ajax_integration_for_blog_application.model.Blog;
import com.example.ajax_integration_for_blog_application.model.Category;
import com.example.ajax_integration_for_blog_application.repository.ICategoryRepository;
import com.example.ajax_integration_for_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteCategory(id);
    }

    @Override
    public void edit(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Blog> findByCategoryName(String name) {
        return categoryRepository.findByCategoryName(name);
    }
}
