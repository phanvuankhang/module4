package com.example.ajax_integration_for_blog_application.controller;

import com.example.ajax_integration_for_blog_application.model.Blog;
import com.example.ajax_integration_for_blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/blog")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Slice<Blog>> getList(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("author"));
        return new ResponseEntity<>(blogService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> showDetailBlog(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam("title") String title) {
        List<Blog> blogList = blogService.search("%" + title + "%");
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
