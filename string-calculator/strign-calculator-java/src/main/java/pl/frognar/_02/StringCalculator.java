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
        var numbersList = convertToInts(splitAndFilterNumbers(numbers));
        AssertDoesNotContainAnyNegativeValue(numbersList);
        return SumNumbers(numbersList);
    }

    static Stream<String> splitAndFilterNumbers(String numbers) {
        return Arrays.stream(numbers.replaceAll("[^0-9-]", ",")
                .split(","))
                .filter(s -> !s.isEmpty());
    }

    static List<Integer> convertToInts(Stream<String> numbers) {
        return numbers
                .map(Integer::parseInt)
                .toList();
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
            String allDelimiters = multipleMatcher.group(0);
            allDelimiters = allDelimiters.substring(2, allDelimiters.length() - 1);
            allDelimiters = allDelimiters.replaceAll("\\Q][\\E", " ");
            allDelimiters = allDelimiters.replaceAll("\\Q[\\E", "");
            allDelimiters = allDelimiters.replaceAll("\\Q]\\E", "");
            List<String> delimiters = Arrays.stream(allDelimiters.split(" "))
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toList();
            for (var delimiter : delimiters) {
                numbers = numbers.replaceAll("\\Q%s\\E".formatted(delimiter), ",");
            }

            return customDelimitersPattern.split(numbers)[1];
        }

        return numbers;
    }
}
