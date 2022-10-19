package pl.frognar._05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTests {
    @ParameterizedTest
    @CsvSource({
            "1,11",
            "11,21",
            "21,1211",
            "1211,111221",
            "111221,312211"
    })
    void nextSequenceElementTest(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    @Test
    void  withDepthOnN() {
        assertEquals("1", Sequence.lookAndSay("1", 0));
    }
}
