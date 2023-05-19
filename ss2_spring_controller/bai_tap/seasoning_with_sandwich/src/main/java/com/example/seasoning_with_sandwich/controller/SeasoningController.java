package com.example.seasoning_with_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeasoningController {
    @GetMapping("")
    public String displayHome() {
        return "/index";
    }

    @PostMapping("/save")
    public String save(Model model, @RequestParam("condiment") String[] condiment) {
        model.addAttribute("condiment", condiment);
        return "/choose";
    }
}