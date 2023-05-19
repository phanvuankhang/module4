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
    private IDictionaryService iDictionaryService;

    @GetMapping("")
    public String displayHome() {
        return "/index";
    }

    @PostMapping("/translate")
    public String translate(Model model, @RequestParam("text") String text) {
        String vietnamese = iDictionaryService.search(text);
        if (vietnamese == null) {
            vietnamese = text + "not found in dictionary";
        }
        model.addAttribute("text", text);
        model.addAttribute("vietnamese", vietnamese);
        return "/index";
    }
}
