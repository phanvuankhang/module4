package com.example.validate_form_register.service.impl;

import com.example.validate_form_register.model.User;
import com.example.validate_form_register.repository.IUserRepository;
import com.example.validate_form_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
