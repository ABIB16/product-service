package productMicroService.productService.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {

    @Autowired
    Calculator calculator;

    @Test
    public void testCalculateAddition() {
        // Given
        int a = 5;
        int b = 10;
        char operator = '+';

        // When
        int result = calculator.calculate(a, b, operator);

        // Then
        int expected = 15;
        Assertions.assertEquals(expected, result, "Addition result is incorrect!");
    }

    @Test
    public void testCalculateSubtraction() {
        // Given
        int a = 15;
        int b = 5;
        char operator = '-';

        // When
        int result = calculator.calculate(a, b, operator);

        // Then
        int expected = 10;
        Assertions.assertEquals(expected, result, "Subtraction result is incorrect!");
    }

    @Test
    public void testCalculateMultiplication() {
        // Given
        int a = 3;
        int b = 7;
        char operator = '*';

        // When
        int result = calculator.calculate(a, b, operator);

        // Then
        int expected = 21;
        Assertions.assertEquals(expected, result, "Multiplication result is incorrect!");
    }

    @Test
    public void testCalculateDivision() {
        // Given
        int a = 20;
        int b = 4;
        char operator = '/';

        // When
        int result = calculator.calculate(a, b, operator);

        // Then
        int expected = 5;
        Assertions.assertEquals(expected, result, "Division result is incorrect!");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(10, 0, operator);
        }, "Division by zero should throw an exception.");
    }

    @Test
    public void testCalculateInvalidOperator() {
        // Given
        int a = 5;
        int b = 10;
        char operator = '%'; // Invalid operator

        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(a, b, operator);
        }, "Invalid operator should throw an exception.");
    }
}
