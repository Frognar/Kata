package pl.frognar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTests {
    @Test
    void oneDigit() {
        assertEquals("11", Sequence.lookAndSay("1"));
    }
}
