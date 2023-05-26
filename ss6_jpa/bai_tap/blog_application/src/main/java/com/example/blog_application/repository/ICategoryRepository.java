package com.example.blog_application.repository;

import com.example.blog_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "UPDATE category SET category.is_delete=true WHERE category.category_id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteCategory(@Param("id") Integer id);
}

