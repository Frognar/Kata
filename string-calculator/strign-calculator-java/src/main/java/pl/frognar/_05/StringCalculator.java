package pl.frognar._05;

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
            var allCustomDelimiters = getAllCustomDelimiters(customDelimiterMatcher.group(1));
            String numbers = replaceAllCustomDelimitersWithComma(originalNumbers, allCustomDelimiters);
            return numbers.substring(numbers.indexOf("\n") + 1);
        }

        return originalNumbers;
    }

    private static List<String> getAllCustomDelimiters(String delimitersGroup) {
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]["), " ");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("["), "");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]"), "");
        return Arrays.stream(delimitersGroup.split(" ")).toList();
    }

    private static String replaceAllCustomDelimitersWithComma(String numbers, List<String> customDelimiters) {
        for (var delimiter: customDelimiters)
            numbers = numbers.replaceAll(escapedRegex.formatted(delimiter), ",");
        return numbers;
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

    private static final String defaultDelimiters = "[,\n]";
    private static List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters))
                .map(Integer::parseInt)
                .toList();
    }

    private static int calculateSumOf(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
