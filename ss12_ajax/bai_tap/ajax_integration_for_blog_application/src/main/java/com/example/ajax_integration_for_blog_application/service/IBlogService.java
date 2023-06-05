package com.example.ajax_integration_for_blog_application.service;

import com.example.ajax_integration_for_blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    void edit(Blog blog);

    List<Blog> search(String title);

    Slice<Blog> findAll(Pageable pageable);
}
