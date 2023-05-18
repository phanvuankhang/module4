package com.example.simple_dictionary.controller;

import com.example.simple_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String translate() {
        return "/index";
    }

    @PostMapping("/translate")
    public String translate(Model model, @RequestParam String text) {
        Map<String, String> map = dictionaryService.translate();
        model.addAttribute("map", map);
        model.addAttribute("text", text);
        return "/index";
    }
}
