package pl.frognar._02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroForEmptyString() {
        var calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
}
