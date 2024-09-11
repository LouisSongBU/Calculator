package me.Louis.config;

import me.Louis.calculator.Operation;
import me.Louis.calculator.strategy.*;
import me.Louis.calculator.Calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CalculatorConfig {
    @Bean
    public Map<Operation, OperationStrategy> operationStrategies() {
        Map<Operation, OperationStrategy> strategies = new HashMap<>();
        strategies.put(Operation.ADD, new AddOperation());
        strategies.put(Operation.SUBTRACT, new SubtractOperation());
        strategies.put(Operation.MULTIPLY, new MultiplyOperation());
        strategies.put(Operation.DIVIDE, new DivideOperation());
        return strategies;
    }

    @Bean
    public Calculator calculator(Map<Operation, OperationStrategy> operationStrategies) {
        return new Calculator(operationStrategies);
    }
}
