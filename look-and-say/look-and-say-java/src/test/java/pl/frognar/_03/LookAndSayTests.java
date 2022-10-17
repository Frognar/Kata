package pl.frognar._03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTests {
    @Test
    void nextSequenceElementTest() {
        assertEquals("11", Sequence.lookAndSay("1"));
    }

}
