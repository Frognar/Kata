package pl.frognar._07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    private static Stream<Arguments> singleNumberInString() {
        return Stream.of(
                arguments("1", 1),
                arguments("5", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("singleNumberInString")
    public void addShouldReturnNumberForSingleNumberInString(String numbers, int expectedSum) {
        assertEquals(expectedSum, calculator.add(numbers));
    }

    private static Stream<Arguments> multipleNumbersSeparatedByDefaultDelimiter() {
        return Stream.of(
                arguments("2,4", 6),
                arguments("2,4,6", 12),
                arguments("2,4\n6", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("multipleNumbersSeparatedByDefaultDelimiter")
    public void addShouldReturnSumOfNumbersSeparatedByDefaultDelimiterInString(String numbers, int expectedSum) {
        assertEquals(expectedSum, calculator.add(numbers));
    }

    private static Stream<Arguments> negativeNumbersAndErrorMessage() {
        return Stream.of(
                arguments("-1", "negatives not allowed: -1")
        );
    }

    @ParameterizedTest
    @MethodSource("negativeNumbersAndErrorMessage")
    public void addShouldThrowExceptionForNegativeNumberInString(String numbers, String expectedExceptionMessage) {
        Exception exception = assertThrows(NegativeNumbersNotAllowedException.class, () -> calculator.add(numbers));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }
}