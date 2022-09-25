package pl.frognar._02;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            String negativesString = negatives
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new NegativeNumbersNotAllowedException(
                    "negatives not allowed: %s".formatted(negativesString));
        }

        return numbersList.stream().reduce(0, Integer::sum);
    }
}
