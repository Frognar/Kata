package pl.frognar._06;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private static final Pattern customDelimiterPattern = Pattern.compile("//(\\[?.+]?)\n");
    private static final String escapedRegex = "\\Q%s\\E";
    private static String replaceCustomDelimiterWithComma(String originalNumbers) {
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(originalNumbers);
        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(1);
            customDelimiter = customDelimiter.replaceAll(escapedRegex.formatted("]["), " ");
            customDelimiter = customDelimiter.replaceAll(escapedRegex.formatted("["), "");
            customDelimiter = customDelimiter.replaceAll(escapedRegex.formatted("]"), "");
            var allCustomDelimiters = customDelimiter.split(" ");
            String numbers = originalNumbers;
            for (var delimiter: allCustomDelimiters) {
                numbers = numbers.replaceAll(escapedRegex.formatted(delimiter), ",");
            }
            return customDelimiterPattern.split(numbers)[1];
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
