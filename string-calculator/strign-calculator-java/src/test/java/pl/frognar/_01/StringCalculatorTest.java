package pl.frognar._01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    static Stream<Arguments> stringWithOneNumber() {
        return Stream.of(
                arguments("1", 1),
                arguments("2", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithOneNumber")
    public void shouldReturnNumberForStringWithOneNumber(String numbers, int expectedValue) {
        StringCalculator calculator = new StringCalculator();
        assertEquals(expectedValue, calculator.add(numbers));
    }

    @Test
    public void shouldReturnSumOfNumbersSeparatedByCommaInString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
}
