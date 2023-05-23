package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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
    public String create(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("show-edit-form")
    public String showEditForm(Model model, int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Product product, int id) {
        productService.edit(product, id);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String delete(int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("search")
    public String search(String search, Model model) {
        List<Product> productList = productService.search(search);
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("show-detail-form")
    public String detail(int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
}
