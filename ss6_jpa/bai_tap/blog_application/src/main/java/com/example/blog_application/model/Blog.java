package com.example.blog_application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String title;
    @Column(columnDefinition = "text", nullable = false)
    private String content;
    @NotNull
    private String author;
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime writingDate;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @ManyToOne()
    private Category category;

    public Blog() {
    }

    public Blog(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Blog(Integer id, String title, String content, String author, LocalDateTime writingDate, LocalDateTime updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.writingDate = writingDate;
        this.updateTime = updateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getWritingDate() {
        return writingDate;
    }

    public void setWritingDate(LocalDateTime writingDate) {
        this.writingDate = writingDate;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}