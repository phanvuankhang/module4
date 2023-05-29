package com.example.validate_form_register.controller;


import com.example.validate_form_register.dto.UserDTO;
import com.example.validate_form_register.model.User;
import com.example.validate_form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
@Autowired
private IUserService userService;

@GetMapping("")
    public String showSignForm(Model model){
    model.addAttribute("userDTO",new UserDTO());
    return "sign";
}
@PostMapping("/create")
    public String create(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
    new UserDTO().validate(userDTO,bindingResult);
    if(bindingResult.hasErrors()) {
        return "sign";
    }
    User user=new User();
    BeanUtils.copyProperties(userDTO,user);
    userService.save(user);
    redirectAttributes.addFlashAttribute("mess","Create is successfully!");
    return "redirect:/";
}
}
