package pl.frognar._03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    public void setUp() {
         calculator = new StringCalculator();
    }

    @Test
    public void addShouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addShouldReturnZeroForNull() {
        assertEquals(0, calculator.add(null));
    }

    private static Stream<Arguments> stringWithOneNumber() {
        return Stream.of(
                arguments("1", 1),
                arguments("2", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithOneNumber")
    public void addShouldReturnNumberForStringWithOneNumber(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByComma() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("1,2,3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByComma")
    public void addShouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByComma(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }
}
