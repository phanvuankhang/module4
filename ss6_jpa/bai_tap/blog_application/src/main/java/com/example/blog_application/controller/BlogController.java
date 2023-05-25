package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog) {
        blogService.edit(blog);
        return "redirect:/";
    }

    @GetMapping("detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
}
