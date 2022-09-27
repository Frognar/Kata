package pl.frognar._04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void addShouldReturnZeroForEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addShouldReturnZeroForNull() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(null));
    }
}
