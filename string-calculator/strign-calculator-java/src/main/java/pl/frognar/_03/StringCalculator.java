package pl.frognar._03;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        var numberList = numbers.split(",");
        return Arrays.stream(numberList).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
