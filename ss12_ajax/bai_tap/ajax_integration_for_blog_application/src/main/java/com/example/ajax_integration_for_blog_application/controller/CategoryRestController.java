package com.example.ajax_integration_for_blog_application.controller;

import com.example.ajax_integration_for_blog_application.model.Blog;
import com.example.ajax_integration_for_blog_application.model.Category;
import com.example.ajax_integration_for_blog_application.service.IBlogService;
import com.example.ajax_integration_for_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{name}")
        public ResponseEntity<List<Blog>> showListInCategory(@PathVariable("name") String name){
        List<Blog>   blogList=categoryService.findByCategoryName('%'+name+'%');
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
