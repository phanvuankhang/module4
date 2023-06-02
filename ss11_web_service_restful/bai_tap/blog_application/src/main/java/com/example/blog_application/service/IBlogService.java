package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;

import java.util.Calendar;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    void edit(Blog blog);

}
