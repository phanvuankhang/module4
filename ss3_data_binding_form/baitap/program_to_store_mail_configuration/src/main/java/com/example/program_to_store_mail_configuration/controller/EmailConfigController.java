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

    @GetMapping("")
    public String displayList(Model model) {
        List<String> languagesList = emailConfigService.languagesList();
        List<Integer> pageSizeList = emailConfigService.pageSizeList();
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("emailConfig", new EmailConfig());
        return "/index";
    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute("emailConfig") EmailConfig emailConfig, Model model) {
        model.addAttribute("emailConfig", emailConfig);
        return "/edit";
    }
}
