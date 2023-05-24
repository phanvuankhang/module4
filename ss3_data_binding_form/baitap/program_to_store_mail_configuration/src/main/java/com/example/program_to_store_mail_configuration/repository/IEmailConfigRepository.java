package com.example.program_to_store_mail_configuration.repository;

import com.example.program_to_store_mail_configuration.model.EmailConfig;

import java.util.List;

public interface IEmailConfigRepository {
    EmailConfig getEmail();

    List<String> findLanguages();

    List<Integer> findPageSize();

    void save(EmailConfig emailConfig);
}
