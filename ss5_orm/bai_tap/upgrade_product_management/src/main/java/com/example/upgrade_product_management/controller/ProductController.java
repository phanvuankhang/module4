package com.example.upgrade_product_management.controller;

import com.example.upgrade_product_management.model.Product;
import com.example.upgrade_product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("show-create-form")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute( "checkCreate", productService.save(product));
        return "redirect:/";
    }

    @GetMapping("show-edit-form/{id}")
    public String showEditForm(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("checkEdit",productService.edit(product));
        return "redirect:/";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("checkDelete",productService.delete(id));
        return "redirect:/";
    }

    @GetMapping("search")
    public String search(String search, Model model) {
        List<Product> productList = productService.search(search);
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("show-detail-form/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
}
