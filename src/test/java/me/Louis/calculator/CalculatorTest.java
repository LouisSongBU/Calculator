package me.Louis.calculator;

import me.Louis.CalculatorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorTest {

    @Autowired
    private Calculator calculator;


    @Test
    public void testAddition() {
        double result = calculator.calculate(Operation.ADD, 2, 3);
        assertEquals(5, result, 0.01);
    }


    @Test
    public void testSubtraction() {
        double result = calculator.calculate(Operation.SUBTRACT, 2, 3);
        assertEquals(-1, result, 0.01);
    }


    @Test
    public void testMultiplication() {
        double result = calculator.calculate(Operation.MULTIPLY, 2, 3);
        assertEquals(6, result, 0.01);
    }


    @Test
    public void testDivision() {
        double result = calculator.calculate(Operation.DIVIDE, 6, 3);
        assertEquals(2, result, 0.01);
    }


    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 1, 0);
        });
    }


    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(Operation.FUTURE, 10, 3);
        });
    }


    @Test
    public void testChainingOperations() {
        double result = calculator
                .start(5)
                .addOperation(Operation.ADD, 3)
                .addOperation(Operation.MULTIPLY, 2)
                .executeChain();
        assertEquals(16, result, 0.01);
    }
}
