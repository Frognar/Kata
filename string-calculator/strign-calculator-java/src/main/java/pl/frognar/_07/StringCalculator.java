package pl.frognar._07;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numbersList = splitAndConvertNumbers(numbers);
        return numbersList.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt).toList();
    }
}
