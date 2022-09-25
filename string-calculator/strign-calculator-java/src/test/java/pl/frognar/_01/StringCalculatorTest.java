package pl.frognar._01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroForEmptyString() {
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
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByComma() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("2,3", 5),
                arguments("1,2,3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByComma")
    public void shouldReturnSumOfNumbersSeparatedByCommaInString(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByNewLine() {
        return Stream.of(
                arguments("1\n2", 3),
                arguments("1\n2,3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByNewLine")
    public void shouldReturnSumOfNumbersSeparatedByNewLineInString(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByCustomDelimiter() {
        return Stream.of(
                arguments("//;\n1;2", 3),
                arguments("//;\n1;2,3", 6),
                arguments("//[;;]\n1;;2,3", 6),
                arguments("//[g][;;]\n1;;2g3", 6),
                arguments("//[**][+][;;;]\n1**2+3;;;4", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByCustomDelimiter")
    public void shouldReturnSumOfNumbersSeparatedByCustomDelimiterInString(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> stringWithNegativeNumbersAndExceptionMessage() {
        return Stream.of(
                arguments("-1", "negatives not allowed: -1"),
                arguments("-1,-2", "negatives not allowed: -1,-2")
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithNegativeNumbersAndExceptionMessage")
    public void shouldThrowExceptionWhenPassedNegativeValues(String numbers, String expectedMessage) {
        Exception exception = assertThrows(NegativeNumbersNotAllowedException.class, () -> calculator.add(numbers));

        assertEquals(expectedMessage, exception.getMessage());
    }


    static Stream<Arguments> stringWithNumbersOverThousand() {
        return Stream.of(
                arguments("1001,2", 2),
                arguments("1000,1001,2", 1002)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithNumbersOverThousand")
    public void shouldIgnoreNumbersOverThousand(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }
}
