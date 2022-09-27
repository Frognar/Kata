package pl.frognar._04;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        numbers = replaceCustomDelimitersWithComma(numbers);
        var numberList = splitAndConvertNumbers(numbers);
        assertDoesNotContainsNegativeValues(numberList);
        return calculateSumOf(numberList);
    }

    private static final Pattern customDelimiterPattern = Pattern.compile("//(\\[?.+]?)\n");
    private static final String escapedRegex = "\\Q%s\\E";
    private String replaceCustomDelimitersWithComma(String numbers) {
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(numbers);
        if (customDelimiterMatcher.find()) {
            var customDelimiter = customDelimiterMatcher.group(1);
            customDelimiter = customDelimiter.replaceAll(escapedRegex.formatted("]["), " ");
            customDelimiter = customDelimiter.replaceAll(escapedRegex.formatted("["), "");
            customDelimiter = customDelimiter.replaceAll(escapedRegex.formatted("]"), "");
            var allCustomDelimiters = customDelimiter.split(" ");
            for (var delimiter: allCustomDelimiters) {
                numbers = numbers.replaceAll(escapedRegex.formatted(delimiter), ",");
            }
            return customDelimiterPattern.split(numbers)[1];
        }

        return numbers;
    }

    private static final String defaultDelimiters = "[,\n]";
    private List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters)).map(Integer::parseInt).toList();
    }

    private void assertDoesNotContainsNegativeValues(List<Integer> numbers) {
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
