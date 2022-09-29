package pl.frognar._06;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt);
        return numberList.reduce(0, Integer::sum);
    }
}
