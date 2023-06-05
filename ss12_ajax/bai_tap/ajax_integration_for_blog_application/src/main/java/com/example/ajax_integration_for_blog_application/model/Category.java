package com.example.ajax_integration_for_blog_application.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "category_name",columnDefinition = "VARCHAR(50)")
    private String categoryName;
    @Column(name = "is_delete",columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;

    public Category() {
    }

    public Category(Integer id, String categoryName, boolean isDelete) {
        this.id = id;
        this.categoryName = categoryName;
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
