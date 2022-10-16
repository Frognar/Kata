package pl.frognar._02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTests {
    @ParameterizedTest
    @CsvSource({"1,11",
                "2,12",
                "11,21",
                "22,22",
                "12,1112",
                "112,2112",
                "1233345,1112331415"})
    void nextSequenceElementTest(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }
}
