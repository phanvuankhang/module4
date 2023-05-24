package com.example.program_to_store_mail_configuration.service;

import com.example.program_to_store_mail_configuration.model.EmailConfig;

import java.util.List;

public interface IEmailConfigService {
    EmailConfig getEmail();
    List<String> findLanguages();
    List<Integer> findPageSize();
    void save(EmailConfig emailConfig);
}
