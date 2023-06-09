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
    public EmailConfig getEmail() {
        if (emailList.size() > 0) {
            return emailList.get(emailList.size() - 1);
        }
        return null;
    }

    @Override
    public List<String> findLanguages() {
        return languageList;
    }

    @Override
    public List<Integer> findPageSize() {
        return pageSizeList;
    }

    @Override
    public void save(EmailConfig emailConfig) {
        emailList.add(emailConfig);
    }
}
