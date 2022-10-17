package pl.frognar._03;

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
            "2,12",
            "11,21",
            "22,22",
            "12,1112",
            "112,2112"
    })
    void nextSequenceElementTest(String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input));
    }

    private static Stream<Arguments> depthInputAndExpected() {
        return Stream.of(
                Arguments.of(1, "1", "11"),
                Arguments.of(2, "1", "11 21")
        );
    }

    @ParameterizedTest
    @MethodSource("depthInputAndExpected")
    void withDepthOfN(int n, String input, String expected) {
        assertEquals(expected, Sequence.lookAndSay(input, n));
    }
}
