package pl.frognar._01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        numbers = numbers.replaceAll("[^0-9-]+", ",");
        Stream<Integer> streamOfNumbers =
                Arrays.stream(numbers.split(","))
                        .filter(s -> !s.isEmpty())
                        .map(Integer::parseInt);
        return calculateSumOf(streamOfNumbers.toList());
    }

    private static int calculateSumOf(List<Integer> numbers) {
        var negatives = numbers.stream().filter(n -> n < 0).toList();
        if (!negatives.isEmpty()) {
            String negativesString = negatives
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new NegativeNumbersNotAllowedException(
                    "negatives not allowed: %s".formatted(negativesString));
        }

        return numbers.stream()
                .filter(n -> n <= 1000)
                .reduce(0, Integer::sum);
    }
}
