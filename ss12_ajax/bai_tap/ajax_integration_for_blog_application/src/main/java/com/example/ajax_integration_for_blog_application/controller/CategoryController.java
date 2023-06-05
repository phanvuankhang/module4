package com.example.ajax_integration_for_blog_application.controller;
import com.example.ajax_integration_for_blog_application.model.Category;
import com.example.ajax_integration_for_blog_application.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model) {
        List<Category> categoryList= categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Create is successfully!");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Delete is successfully!");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.edit(category);
        redirectAttributes.addFlashAttribute("mess","Edit is successfully!");
        return "redirect:/category";
    }

    @GetMapping("detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/detail";
    }
}
