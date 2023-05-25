package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("/")
    public String showList(Model model){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }
}
