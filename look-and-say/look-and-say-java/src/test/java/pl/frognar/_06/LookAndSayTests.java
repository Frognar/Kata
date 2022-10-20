package pl.frognar._06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    private static Stream<Arguments> depthInputAndExpected() {
        return Stream.of(
                Arguments.of("1", 0, "1"),
                Arguments.of("1", 1, "1 -> 11"),
                Arguments.of("1", 2, "1 -> 11 -> 21"),
                Arguments.of("1", 3, "1 -> 11 -> 21 -> 1211")
        );
    }

    @ParameterizedTest
    @MethodSource("depthInputAndExpected")
    void withDepthOnN(String input, int depth, String expected) {
        assertEquals(expected, pl.frognar._05.Sequence.lookAndSay(input, depth));
    }
}
