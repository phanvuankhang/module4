package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.ICartService;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService cartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> initCart() {
        return new LinkedHashMap<>();
    }

    @GetMapping("")
    public String showShop(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "shop";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") Long id, RedirectAttributes redirectAttributes,
                            @ModelAttribute("cart") Map<Product, Integer> productIntegerMap) {
        Product product = productService.findById(id);
        if (!cartService.checkExits(product, productIntegerMap)) {
            productIntegerMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> m = cartService.productIntegerEntry(product, productIntegerMap);

            Integer quantity = m.getValue() + 1;
            productIntegerMap.replace(m.getKey(), quantity);
        }
        redirectAttributes.addFlashAttribute("mess", "ADDED");

        return "redirect:/";
    }
}
