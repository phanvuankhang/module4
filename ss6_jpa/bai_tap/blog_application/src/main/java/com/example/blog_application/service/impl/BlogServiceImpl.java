package com.example.blog_application.service.impl;

import com.example.blog_application.model.Blog;
import com.example.blog_application.repository.IBlogRepository;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {

@Autowired
private IBlogRepository repository;
    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }
}
