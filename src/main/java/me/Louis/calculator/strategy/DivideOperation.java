package me.Louis.calculator.strategy;

public class DivideOperation implements OperationStrategy {
    @Override
    public double execute(double num1, double num2) {

        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return num1 / num2;
    }
}
