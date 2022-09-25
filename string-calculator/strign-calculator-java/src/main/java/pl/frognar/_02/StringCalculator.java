package pl.frognar._02;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        var numbersList = numbers.split("[,\n]");
        return Arrays.stream(numbersList).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
