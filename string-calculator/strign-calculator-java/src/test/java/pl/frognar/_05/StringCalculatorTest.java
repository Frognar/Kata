package pl.frognar._05;

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

    private static Stream<Arguments> oneNumber() {
        return Stream.of(
                arguments("1", 1),
                arguments("2", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("oneNumber")
    public void addShouldReturnNumberForStringWithOneNumber(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    private static Stream<Arguments> multipleNumbersSeparatedByDefaultDelimiter() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("1,2,3", 6),
                arguments("1\n2,3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("multipleNumbersSeparatedByDefaultDelimiter")
    public void addShouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByDefaultDelimiter(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }

    private static Stream<Arguments> negativeNumbersAndExceptionMessage() {
        return Stream.of(
                arguments("-1", "negatives not allowed: -1"),
                arguments("-1,-2", "negatives not allowed: -1,-2")
        );

    }

    @ParameterizedTest
    @MethodSource("negativeNumbersAndExceptionMessage")
    public void addShouldThrowExceptionWhenPassedNegativeValues(String numbers, String expectedMessage) {
        Exception exception = assertThrows(NegativeNumbersNotAllowedException.class, () -> calculator.add(numbers));
        assertEquals(exception.getMessage(), expectedMessage);
    }

    private static Stream<Arguments> numbersSeparatedByCustomDelimiter() {
        return Stream.of(
                arguments("//;\n1;2,3", 6),
                arguments("//[;!;]\n1;!;2;!;3", 6),
                arguments("//[*]\n1*2*3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersSeparatedByCustomDelimiter")
    public void addShouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByCustomDelimiter(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }
}
