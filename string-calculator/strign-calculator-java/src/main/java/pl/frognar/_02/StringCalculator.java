package pl.frognar._02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        var numbersList = convertToInts(splitAndFilterNumbers(numbers));
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

    Stream<String> splitAndFilterNumbers(String numbers) {
        return Arrays.stream(numbers.replaceAll("[^0-9-]", ",")
                .split(","))
                .filter(s -> !s.isEmpty());
    }

    List<Integer> convertToInts(Stream<String> numbers) {
        return numbers
                .map(Integer::parseInt)
                .toList();
    }
}
