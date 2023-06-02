package com.example.blog_application.repository;

import com.example.blog_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {


}
