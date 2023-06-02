package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);

    void save(Category category);

    void delete(Integer id);

    void edit(Category category);

    List<Blog> findByCategoryName(String name);
}
