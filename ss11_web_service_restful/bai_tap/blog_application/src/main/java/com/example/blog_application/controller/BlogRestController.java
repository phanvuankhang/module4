package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getList(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Blog> showDetailBlog(@PathVariable("id")Integer id){
        return new ResponseEntity<>(blogService.findById(id),HttpStatus.OK);
    }
}
