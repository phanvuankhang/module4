package com.example.ajax_integration_for_blog_application.service.impl;

import com.example.ajax_integration_for_blog_application.model.Blog;
import com.example.ajax_integration_for_blog_application.repository.IBlogRepository;
import com.example.ajax_integration_for_blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> search(String title) {
        return blogRepository.searchBlogByTitle(title);
    }

    @Override
    public Slice<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
