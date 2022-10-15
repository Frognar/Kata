package pl.frognar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTests {
    @ParameterizedTest
    @CsvSource({"1,11",
                "2,12"})
    void oneDigit(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @ParameterizedTest
    @CsvSource({"12,1112",
                "21,1211"})
    void twoDifferentDigits(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @ParameterizedTest
    @CsvSource({"11,21",
                "22,22"})
    void twoIdenticalDigits(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @ParameterizedTest
    @CsvSource({"123,111213"})
    void threeDifferentDigits(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @ParameterizedTest
    @CsvSource({"112,2112"})
    void twoConsecutiveIdenticalDigitsWithinThree(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @ParameterizedTest
    @CsvSource({"1121,211211"})
    void twoIdenticalDigitsAtDifferentLocations(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @Test
    void depthOfOne() {
        assertEquals("11", Sequence.lookAndSay("1", 1));
    }

    @Test
    void depthOfTwo() {
        assertEquals("11 21", Sequence.lookAndSay("1", 2));
    }

    @Test
    void depthOfThree() {
        assertEquals("11 21 1211", Sequence.lookAndSay("1", 3));
    }

    private static Stream<Arguments> depthAndExpected() {
        return Stream.of(
                Arguments.of(1, "1", "11"),
                Arguments.of(2, "1", "11 21"),
                Arguments.of(3, "1", "11 21 1211")
        );
    }

    @ParameterizedTest
    @MethodSource("depthAndExpected")
    void depthOfN(int n, String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input, n));
    }
}
