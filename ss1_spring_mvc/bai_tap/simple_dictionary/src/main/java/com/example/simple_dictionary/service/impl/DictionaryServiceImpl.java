package com.example.simple_dictionary.service.impl;

import com.example.simple_dictionary.repository.IDictionaryRepository;
import com.example.simple_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    private IDictionaryRepository iDictionaryRepository;

    @Override
    public String search(String text) {
        Map<String, String> stringMap = iDictionaryRepository.translate();
        Set<String> key = stringMap.keySet();
        for (String k : key) {
            if (text.toLowerCase().equals(k)) {
                return stringMap.get(k);
            }
        }
        return null;
    }
}
