package pl.frognar._05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTests {
    @ParameterizedTest
    @CsvSource({
            "1,11"
    })
    void nextSequenceElementTest(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }
}
