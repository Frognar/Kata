package pl.frognar;

import org.junit.jupiter.api.Test;
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

    @Test
    void twoDifferentDigits() {
        assertEquals("1112", Sequence.lookAndSay("12"));
    }
}
