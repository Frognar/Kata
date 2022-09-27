package pl.frognar._04;

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

    private static Stream<Arguments> stringWithMultipleNumbersSeparatedByDefaultDelimiter() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("1,2,3", 6),
                arguments("1,2\n3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByDefaultDelimiter")
    public void addShouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByDefaultDelimiter(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    private static Stream<Arguments> stringWithNegativeNumbersAndExceptionMessage() {
        return Stream.of(
                arguments("-1", "negatives not allowed: -1"),
                arguments("-1,-2", "negatives not allowed: -1,-2")
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithNegativeNumbersAndExceptionMessage")
    public void addShouldThrowExceptionWhenPassedNegativeValues(String numbers, String expectedMessage) {
        Exception exception = assertThrows(NegativeNumbersNotAllowedException.class, () -> calculator.add(numbers));
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> stringWithMultipleNumbersSeparatedByCustomDelimiter() {
        return Stream.of(
                arguments("//;\n1;2;3", 6),
                arguments("//!\n1!2!3", 6),
                arguments("//[;!;]\n1;!;2;!;3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByCustomDelimiter")
    public void addShouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByCustomDelimiter(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    private static Stream<Arguments> stringWithMultipleNumbersSeparatedByMultipleCustomDelimiter() {
        return Stream.of(
                arguments("//[;][+]\n1;2+3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByMultipleCustomDelimiter")
    public void addShouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByMultipleCustomDelimiters(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }
}
