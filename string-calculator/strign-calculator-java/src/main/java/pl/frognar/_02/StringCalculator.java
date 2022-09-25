package pl.frognar._02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        numbers = replaceAllCustomDelimitersToCommas(numbers);
        var numbersList = convertToInts(splitAndFilterNumbers(numbers));
        AssertDoesNotContainAnyNegativeValue(numbersList);
        return SumNumbers(numbersList);
    }

    static Stream<String> splitAndFilterNumbers(String numbers) {
        return Arrays.stream(numbers.split("[,\n]"));
    }

    static List<Integer> convertToInts(Stream<String> numbers) {
        return numbers.map(Integer::parseInt).toList();
    }

    static void AssertDoesNotContainAnyNegativeValue(List<Integer> numbers) {
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

    static int SumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static final Pattern customDelimitersPattern = Pattern.compile("//(\\[?.+]?)+\n");
    static String replaceAllCustomDelimitersToCommas(String numbers) {
        Matcher multipleMatcher = customDelimitersPattern.matcher(numbers);
        if (multipleMatcher.find()) {
            List<String> delimiters = getAllCustomDelimiters(multipleMatcher.group(0));
            numbers = replaceAllDelimitersWithComma(numbers, delimiters);
            return customDelimitersPattern.split(numbers)[1];
        }

        return numbers;
    }

    private static List<String> getAllCustomDelimiters(String delimitersGroup) {
        delimitersGroup = delimitersGroup.substring(2, delimitersGroup.length() - 1);
        delimitersGroup = delimitersGroup.replaceAll("\\Q][\\E", " ");
        delimitersGroup = delimitersGroup.replaceAll("\\Q[\\E", "");
        delimitersGroup = delimitersGroup.replaceAll("\\Q]\\E", "");
        return Arrays.stream(delimitersGroup.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
    }

    private static String replaceAllDelimitersWithComma(String originalNumbers, List<String> delimiters) {
        String escapedRegex = "\\Q%s\\E";
        for (var delimiter : delimiters) {
            originalNumbers = originalNumbers.replaceAll(escapedRegex.formatted(delimiter), ",");
        }
        return originalNumbers;
    }
}
