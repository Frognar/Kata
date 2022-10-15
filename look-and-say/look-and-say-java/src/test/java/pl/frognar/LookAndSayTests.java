package pl.frognar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
