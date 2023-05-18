package com.example.currency_converter.controller;

import com.example.currency_converter.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurrencyController {
    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("")
    public String showResult() {
        return "/index";
    }

    @PostMapping("/change")
    public String convert(Model model, @RequestParam int usd) {
        int result = currencyService.convertVnd(usd);
        model.addAttribute("result", result);
        return "/index";
    }
}
