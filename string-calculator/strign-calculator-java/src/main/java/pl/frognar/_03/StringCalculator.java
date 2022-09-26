package pl.frognar._03;

import java.util.Arrays;
import java.util.Comparator;
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
        AssertDoesNotContainsNegativeValues(numberList);
        return calculateSumOf(numberList);
    }

    private static final Pattern customDelimiterPattern = Pattern.compile("//(\\[?.+]?)+\n");
    private static final String escapedRegex = "\\Q%s\\E";
    private String replaceCustomDelimitersWithComma(String numbers) {
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(numbers);
        if (customDelimiterMatcher.find()) {
            var allCustomDelimiters = getAllCustomDelimiters(customDelimiterMatcher.group(1));
            for (var delimiter: allCustomDelimiters) {
                numbers = numbers.replaceAll(escapedRegex.formatted(delimiter), ",");
            }
            return customDelimiterPattern.split(numbers)[1];
        }
        return numbers;
    }

    private static List<String> getAllCustomDelimiters(String delimitersGroup) {
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]["), " ");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("["), "");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]"), "");
        return  Arrays.stream(delimitersGroup.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
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
