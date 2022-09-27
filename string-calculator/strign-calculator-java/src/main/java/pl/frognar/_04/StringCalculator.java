package pl.frognar._04;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        var numberList = numbers.split("[,\n]");
        return Arrays.stream(numberList).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
