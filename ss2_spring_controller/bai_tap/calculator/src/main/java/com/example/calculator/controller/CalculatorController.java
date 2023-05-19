package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("")
    public String displayHome() {
        return "/index";
    }

    @PostMapping("/calculate")
    public String calculate(Model model, Float number1, Float number2, String math) {
        if (number1 == null) {
            number1 = 0f;
        }
        if (number2 == null) {
            number2 = 0f;
        }
        String result = "Result " + math+ ": " + iCalculatorService.calculate(number1, number2, math);
        if (result == null) {
            result = "Không có kết quả";
        }
        model.addAttribute("result", result);
        return "/index";
    }
}
