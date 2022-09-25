package pl.frognar._02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        numbers = numbers.replaceAll("[^0-9-]", ",");
        String delimiters = ",";
        var numbersList = convertToInts(numbers.split(delimiters));
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

    List<Integer> convertToInts(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }
}
