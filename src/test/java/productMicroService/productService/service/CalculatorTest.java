package productMicroService.productService.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import productMicroService.productService.controller.CalculatorController;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculatorTest {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private CalculatorController calculatorController;

    // initialiser les mocks avant chaque test
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateAddition() {
        when(calculator.calculate(5, 10,'+')).thenReturn(15);

        int result = calculatorController.calculate(5, 10,'+');

        // Then
        int expected = 15;
        Assertions.assertEquals(expected, result, "Addition result is incorrect!");
    }

    @Test
    public void testCalculateSubtraction() {
        when(calculator.calculate(15, 5,'-')).thenReturn(10);

        int result = calculatorController.calculate(15, 5,'-');

        // Then
        int expected = 10;
        Assertions.assertEquals(expected, result, "Subtraction result is incorrect!");
    }

    @Test
    public void testCalculateMultiplication() {
        when(calculator.calculate(3, 7,'*')).thenReturn(21);

        int result = calculatorController.calculate(3, 7,'*');

        // Then
        int expected = 21;
        Assertions.assertEquals(expected, result, "Multiplication result is incorrect!");
    }

    @Test
    public void testCalculateDivision() {
        when(calculator.calculate(20, 4,'/')).thenReturn(5);

        int result = calculatorController.calculate(20, 4,'/');


        // Then
        int expected = 5;
        Assertions.assertEquals(expected, result, "Division result is incorrect!");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(10, 0, '/');
        }, "Division by zero should throw an exception.");
    }

    /*@Test
    public void testCalculateInvalidOperator() {
        when(calculator.calculate(5, 10,'%')).thenReturn(null);


        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(5,10, '%');
        }, "Invalid operator should throw an exception.");
    }*/
}
