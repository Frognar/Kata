package pl.frognar._06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void addShouldReturnZeroForNull() {
        assertEquals(0, calculator.add(null));
    }

    @Test
    public void addShouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addShouldReturnNumberForStringWithOneNumber() {
        assertEquals(1, calculator.add("1"));
    }
}
