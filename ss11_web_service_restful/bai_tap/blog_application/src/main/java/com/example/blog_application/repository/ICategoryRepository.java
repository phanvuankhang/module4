package com.example.blog_application.repository;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
        @Query(value = "update category set is_delete = 1 where id = :id", nativeQuery = true)
        @Modifying
        @Transactional
        void deleteCategory(@Param("id") Integer id);

        @Query(value = "select b from Blog b where b.category.categoryName like :name")
        List<Blog> findByCategoryName(String name);
}

