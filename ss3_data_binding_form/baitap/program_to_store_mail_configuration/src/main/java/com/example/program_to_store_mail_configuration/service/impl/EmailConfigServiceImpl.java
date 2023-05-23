package com.example.program_to_store_mail_configuration.service.impl;

import com.example.program_to_store_mail_configuration.model.EmailConfig;
import com.example.program_to_store_mail_configuration.repository.IEmailConfigRepository;
import com.example.program_to_store_mail_configuration.service.IEmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailConfigServiceImpl implements IEmailConfigService {
    @Autowired
    private IEmailConfigRepository emailConfigRepository;

    @Override
    public List<EmailConfig> findAll() {
        return emailConfigRepository.findAll();
    }

    @Override
    public List<String> findLanguages() {
        return emailConfigRepository.findLanguages();
    }

    @Override
    public List<Integer> findPageSize() {
        return emailConfigRepository.findPageSize();
    }

    @Override
    public void save(EmailConfig emailConfig) {
        emailConfigRepository.save(emailConfig);
    }
}
