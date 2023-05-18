package com.example.simple_dictionary.service.impl;

import com.example.simple_dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Override
    public Map<String, String> translate() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("hello", "xin chào");
        map.put("banana", "chuối");
        map.put("apple", "quả táo");
        return map;
    }
}
