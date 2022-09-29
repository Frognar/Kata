package pl.frognar._06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        numbers = replaceCustomDelimiterWithComma(numbers);
        var numberList = splitAndConvertNumbers(numbers);
        assertDoesNotContainsNegativeValues(numberList);
        return calculateSumOf(numberList);
    }

    private static String replaceCustomDelimiterWithComma(String originalNumbers) {
        if (originalNumbers.startsWith("//")) {
            char customDelimiter = originalNumbers.charAt(2);
            String delimiter = "%s".formatted(customDelimiter);
            String numbers = originalNumbers.replaceAll(delimiter, ",");
            return numbers.substring(4);
        }

        return originalNumbers;
    }

    private static final String defaultDelimiters = "[,\n]";
    private List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters))
                .map(Integer::parseInt)
                .toList();
    }

    private static void assertDoesNotContainsNegativeValues(List<Integer> numbers) {
        var negatives = numbers.stream().filter(n -> n < 0).toList();
        if (!negatives.isEmpty()) {
            String negativesString = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new NegativeNumbersNotAllowedException(
                    "negatives not allowed: %s".formatted(negativesString));
        }
    }

    private int calculateSumOf(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
