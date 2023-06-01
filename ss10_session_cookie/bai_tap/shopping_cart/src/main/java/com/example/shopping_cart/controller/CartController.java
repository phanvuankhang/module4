package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.ICartService;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IProductService productService;

    @GetMapping("/cart")
    public String showCart(@SessionAttribute("cart") Map<Product, Integer> productIntegerMap, Model model) {
        model.addAttribute("cart", productIntegerMap);
        double total = cartService.getTotal(productIntegerMap);
        model.addAttribute("total", total);
        return "shopping-cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, RedirectAttributes redirectAttributes,
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

        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable("id") Long id, RedirectAttributes redirectAttributes,
                               @ModelAttribute("cart") Map<Product, Integer> productIntegerMap) {
        Product product = productService.findById(id);
        Integer quantity;
        if (!cartService.checkExits(product, productIntegerMap)) {
            productIntegerMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> m = cartService.productIntegerEntry(product, productIntegerMap);

            quantity = m.getValue() - 1;
            productIntegerMap.replace(m.getKey(), quantity);
            if (m.getValue() == 0) {
                productIntegerMap.remove(m.getKey());
            }
        }

        return "redirect:/cart";
    }
}
