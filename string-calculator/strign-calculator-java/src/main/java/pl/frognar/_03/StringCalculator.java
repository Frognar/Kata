package pl.frognar._03;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        var numberList = splitAndConvertNumbers(numbers);
        return numberList.reduce(0, Integer::sum);
    }

    private static final String defaultDelimiters = "[,\n]";
    private Stream<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters)).map(Integer::parseInt);
    }
}
