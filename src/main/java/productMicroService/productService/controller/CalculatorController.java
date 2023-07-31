package productMicroService.productService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import productMicroService.productService.service.Calculator;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private Calculator calculator;

    @GetMapping("/calculator")
    public int calculate(@RequestParam int a, @RequestParam int b, @RequestParam char operateur) {
        return calculator.calculate(a, b,operateur);
    }

   /* @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return calculator.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return calculator.multiply(a, b);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return calculator.divide(a, b);
    }*/
}
