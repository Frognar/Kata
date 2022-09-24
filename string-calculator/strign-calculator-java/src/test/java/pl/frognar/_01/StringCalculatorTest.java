package pl.frognar._01;

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
    public void setUp(){
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
                arguments("1\n2", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithMultipleNumbersSeparatedByNewLine")
    public void shouldReturnSumOfNumbersSeparatedByNewLineInString(String numbers, int expectedValue) {
        assertEquals(expectedValue, calculator.add(numbers));
    }
}
