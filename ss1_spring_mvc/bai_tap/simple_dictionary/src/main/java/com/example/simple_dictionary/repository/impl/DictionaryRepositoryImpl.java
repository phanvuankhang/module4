package com.example.simple_dictionary.repository.impl;

import com.example.simple_dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements IDictionaryRepository {
    @Autowired
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("hello", "Xin chào");
        stringMap.put("banana", "Chuối");
        stringMap.put("apple", "Quả táo");
        stringMap.put("pen", "Cây bút");
        stringMap.put("coffe", "Cà phê");
        stringMap.put("key", "Khóa");
    }

    @Override
    public Map<String, String> translate() {
        return stringMap;
    }
}
