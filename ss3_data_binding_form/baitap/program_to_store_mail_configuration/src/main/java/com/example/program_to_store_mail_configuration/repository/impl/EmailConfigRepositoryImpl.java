package com.example.program_to_store_mail_configuration.repository.impl;

import com.example.program_to_store_mail_configuration.model.EmailConfig;
import com.example.program_to_store_mail_configuration.repository.IEmailConfigRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailConfigRepositoryImpl implements IEmailConfigRepository {
    private static List<EmailConfig> emailList = new ArrayList<>();

    static {
        emailList.add(new EmailConfig("Vietnamese", 10, false, "Thor King, Asgard"));
        emailList.add(new EmailConfig("English", 50, true, "Anna King, Asgard"));
        emailList.add(new EmailConfig("Vietnamese", 10, false, "Agenea King, Regard"));
    }

    private static List<String> languageList = new ArrayList<>();

    static {

        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<EmailConfig> findAll() {
        return emailList;
    }

    @Override
    public List<String> findLanguages() {
        return findLanguages();
    }

    @Override
    public List<Integer> findPageSize() {
        return findPageSize();
    }

    @Override
    public void save(EmailConfig emailConfig) {
        emailList.add(emailConfig);
    }
}
