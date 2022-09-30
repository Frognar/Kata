package pl.frognar._07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        if (numbers.startsWith("//")) {
            String customDelimiter = "%s".formatted(numbers.charAt(2));
            numbers = numbers.substring(numbers.indexOf('\n') + 1);
            numbers = numbers.replaceAll(customDelimiter, ",");
        }
        var numbersList = splitAndConvertNumbers(numbers);
        assertNotContainsNegativeNumbers(numbersList);
        return calculateSumOfNumbers(numbersList);
    }

    private static final String defaultDelimiters = "[,\n]";
    private static List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters))
                .map(Integer::parseInt).toList();
    }

    private static void assertNotContainsNegativeNumbers(List<Integer> numbers) {
        var negatives = numbers.stream().filter(n -> n < 0).toList();
        if (!negatives.isEmpty()) {
            var negativesString = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new NegativeNumbersNotAllowedException(
                    "negatives not allowed: %s".formatted(negativesString));
        }
    }

    private static int calculateSumOfNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
