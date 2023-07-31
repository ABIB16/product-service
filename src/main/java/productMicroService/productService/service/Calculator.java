package productMicroService.productService.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int calculate(int a, int b, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return result;
    }
}
