package com.example.program_to_store_mail_configuration.repository;

import com.example.program_to_store_mail_configuration.model.EmailConfig;

import java.util.List;

public interface IEmailConfigRepository {
    List<EmailConfig> findAll();
    List<String> languagesList();
    List<Integer> pageSizeList();
}
