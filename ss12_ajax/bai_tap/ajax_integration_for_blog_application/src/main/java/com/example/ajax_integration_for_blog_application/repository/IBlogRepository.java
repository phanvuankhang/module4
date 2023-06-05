package com.example.ajax_integration_for_blog_application.repository;

import com.example.ajax_integration_for_blog_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select b from Blog b where b.title like :title")
    List<Blog> searchBlogByTitle(String title);
}
