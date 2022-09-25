package pl.frognar._02;

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
        var calculator = new StringCalculator();
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
        var calculator = new StringCalculator();
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
    public void shouldReturnSumOfNumbersForStringWithMultipleNumbersInStringSeparatedByComma(String numbers, int expectedValue) {
        var calculator = new StringCalculator();assertEquals(expectedValue, calculator.add(numbers));
    }
}
