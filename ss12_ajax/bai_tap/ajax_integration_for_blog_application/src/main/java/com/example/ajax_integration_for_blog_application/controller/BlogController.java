package com.example.ajax_integration_for_blog_application.controller;

import com.example.ajax_integration_for_blog_application.model.Blog;
import com.example.ajax_integration_for_blog_application.service.IBlogService;
import com.example.ajax_integration_for_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private ICategoryService categoryService;
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
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Create is successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete is successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit is successfully!");
        return "redirect:/";
    }

    @GetMapping("detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }
}
