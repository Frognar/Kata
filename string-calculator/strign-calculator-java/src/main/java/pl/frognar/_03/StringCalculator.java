package pl.frognar._03;

import java.util.Arrays;

public class StringCalculator {
    private static final String defaultDelimiters = "[,\n]";
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        var numberList = numbers.split(defaultDelimiters);
        return Arrays.stream(numberList).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
