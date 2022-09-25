package pl.frognar._02;

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

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByDefaultDelimiter() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("1,2,3", 6),
                arguments("1\n2,3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByDefaultDelimiter")
    public void shouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByDefaultDelimiter(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByCustomDelimiter() {
        return Stream.of(
                arguments("//;\n1;2;3", 6),
                arguments("//!\n1!2!3", 6),
                arguments("//[;!;]\n1;!;2;!;3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByCustomDelimiter")
    public void shouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByCustomDelimiter(String numbers, int expectedValue) {
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

    static Stream<Arguments> stringWithMultipleNumbersSeparatedByMultipleCustomDelimiter() {
        return Stream.of(
                arguments("//[;][+]\n1;2+3", 6),
                arguments("//[;][++]\n1;2++3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByMultipleCustomDelimiter")
    public void shouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByMultipleCustomDelimiter(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    static Stream<Arguments> customDelimiters() {
        return Stream.of(
                arguments("1,2,3", "1,2,3"),
                arguments("//;\n1;2,3", "1,2,3"),
                arguments("//;\n1;2\n3", "1,2\n3"),
                arguments("//[;]\n1;2\n3", "1,2\n3"),
                arguments("//[;;]\n1;;2;;3", "1,2,3"),
                arguments("//[;][+]\n1;2+3", "1,2,3"),
                arguments("//[;;][+]\n1;;2+3", "1,2,3"),
                arguments("//[;;][g][***]\n1;;2g3***4","1,2,3,4"),
                arguments("//[;;][g][***]\n1;;2g3****4", "1,2,3,*4"),
                arguments("//[;;][g][***][***+]\n1;;2g3***+4", "1,2,3,4")
        );
    }

    @ParameterizedTest
    @MethodSource("customDelimiters")
    public void replaceCustomDelimitersWithCommas(String numbers, String expectedNumbers) {
        assertEquals(expectedNumbers, StringCalculator.replaceAllCustomDelimitersToCommas(numbers));
    }
}
