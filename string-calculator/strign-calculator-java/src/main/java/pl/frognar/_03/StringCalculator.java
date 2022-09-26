package pl.frognar._03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        numbers = replaceCustomDelimitersWithComma(numbers);
        var numberList = splitAndConvertNumbers(numbers);
        AssertDoesNotContainsNegativeValues(numberList);
        return calculateSumOf(numberList);
    }

    private String replaceCustomDelimitersWithComma(String numbers) {
        if (numbers.startsWith("//")) {
            char customDelimiter = numbers.charAt(2);
            String delimiter = "%s".formatted(customDelimiter);
            if (customDelimiter == '[') {
                delimiter = numbers.substring(3, numbers.indexOf(']'));
            }
            numbers = numbers.replaceAll(delimiter, ",");
            return numbers.substring(numbers.indexOf('\n') + 1);
        }

        return numbers;
    }

    private static final String defaultDelimiters = "[,\n]";
    private List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void AssertDoesNotContainsNegativeValues(List<Integer> numbers) {
        var negatives = numbers.stream().filter(n -> n < 0).toList();
        if (!negatives.isEmpty()) {
            String negativesString = negatives
                    .stream()
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
