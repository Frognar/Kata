package pl.frognar._07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void addShouldReturnZeroForNull() {
        var calculator = new StringCalculator();
        assertEquals(0, calculator.add(null));
    }

    @Test
    public void addShouldReturnZeroForEmptyString() {
        var calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
}
