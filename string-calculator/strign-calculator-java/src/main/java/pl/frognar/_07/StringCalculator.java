package pl.frognar._07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        numbers = replaceCustomDelimiterWithComma(numbers);
        var numbersList = splitAndConvertNumbers(numbers);
        assertNotContainsNegativeNumbers(numbersList);
        return calculateSumOfNumbers(numbersList);
    }

    private static final Pattern customDelimiterPattern = Pattern.compile("//(\\[?.+]?)\n");
    private static String replaceCustomDelimiterWithComma(String numbers) {
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(numbers);
        if (customDelimiterMatcher.find()) {
            var allCustomDelimiters = getAllCustomDelimiters(customDelimiterMatcher.group(1));
            numbers = replaceAllCustomDelimitersWithComma(numbers, allCustomDelimiters);
            return customDelimiterPattern.split(numbers)[1];
        }
        return numbers;
    }

    private static final String escapedRegex = "\\Q%s\\E";
    private static List<String> getAllCustomDelimiters(String delimitersGroup) {
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]["), " ");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("["), "");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]"), "");
        return Arrays.stream(delimitersGroup.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
    }

    private static String replaceAllCustomDelimitersWithComma(String numbers, List<String> customDelimiters) {
        for (var delimiter : customDelimiters)
            numbers = numbers.replaceAll(escapedRegex.formatted(delimiter), ",");
        return numbers;
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
