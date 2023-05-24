package com.example.program_to_store_mail_configuration.controller;

import com.example.program_to_store_mail_configuration.model.EmailConfig;
import com.example.program_to_store_mail_configuration.service.IEmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class EmailConfigController {
    @Autowired
    private IEmailConfigService emailConfigService;

    @GetMapping("/")
    public String showHome() {

        return "/setting";
    }

    @GetMapping("/setting")
    public String setting(Model model) {
        List<String> languages = emailConfigService.findLanguages();
        List<Integer> pageSize = emailConfigService.findPageSize();
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("emailConfig", emailConfigService.getEmail());
        return "/index";
    }

    @PostMapping("/update")
    public String saveSetting(Model model, @ModelAttribute("emailConfig") EmailConfig emailConfig) {
        emailConfigService.save(emailConfig);
        return "/setting";
    }
}
