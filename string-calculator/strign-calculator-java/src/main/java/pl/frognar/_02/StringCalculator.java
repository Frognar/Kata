package pl.frognar._02;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        numbers = numbers.replaceAll("[^0-9-]", ",");
        String delimiters = ",";
        var numbersList = Arrays.stream(numbers.split(delimiters))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();

        var negatives = numbersList.stream().filter(n -> n < 0).toList();
        if (!negatives.isEmpty()) {
            throw new NegativeNumbersNotAllowedException("negatives not allowed: -1");
        }

        return numbersList.stream().reduce(0, Integer::sum);
    }
}
