package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public Float calculate(Float number1, Float number2, String math) {
        Float calculateResult;
        switch (math) {
            case "Addition":
                calculateResult = number1 + number2;
                break;
            case "Subtraction":
                calculateResult = number1 - number2;
                break;
            case "Multiplication":
                calculateResult = number1 * number2;
                break;
            case "Division":
                calculateResult = number1 / number2;
                break;
            default:
                calculateResult = null;
        }
        return calculateResult;
    }
}
