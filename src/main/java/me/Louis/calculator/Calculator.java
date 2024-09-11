package me.Louis.calculator;

import me.Louis.calculator.strategy.OperationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculator {
    private final Map<Operation, OperationStrategy> strategies;
    private double currentValue;
    private final List<OperationStep> operationSteps = new ArrayList<>();

    public Calculator(Map<Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
        this.currentValue = 0;
    }


    public double calculate(Operation op, double num1, double num2) {
        OperationStrategy strategy = strategies.get(op);

        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        return strategy.execute(num1, num2);
    }


    public Calculator start(double initialValue) {
        this.currentValue = initialValue;
        return this;
    }


    public Calculator addOperation(Operation operation, double value) {
        operationSteps.add(new OperationStep(operation, value));
        return this;
    }


    public double executeChain() {
        for (OperationStep step : operationSteps) {
            currentValue = calculate(step.operation, currentValue, step.value);
        }
        operationSteps.clear();
        return currentValue;
    }
}
