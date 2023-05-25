package com.example.blog_application.service;

import com.example.blog_application.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);

    void edit(Blog blog);
}
