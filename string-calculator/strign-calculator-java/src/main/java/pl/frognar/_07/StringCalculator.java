package pl.frognar._07;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numbersList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt).toList();
        return numbersList.stream().reduce(0, Integer::sum);
    }
}
