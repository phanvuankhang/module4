package com.example.currency_converter.service.impl;

import com.example.currency_converter.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements ICurrencyService {

    @Override
    public int convertVnd(int usd) {
        return usd * 23000;
    }
}
