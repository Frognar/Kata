package pl.frognar._01;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private final String customDelimiterRegex = "//(.+)\n";
    private final Pattern customDelimiterPattern = Pattern.compile(customDelimiterRegex);
    private final String extractDelimiterRegex = "\\[?([^]]+)]?";
    private final Pattern extractDelimiterPattern = Pattern.compile(extractDelimiterRegex);

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiters = "[,\\n]";
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(numbers);
        if (customDelimiterMatcher.find()) {
            delimiters += "%s".formatted(mergeCustomDelimiter(customDelimiterMatcher));
            numbers = skipCustomDelimiter(numbers);
        }

        return calculateSumOf(numbers.split(delimiters));
    }

    private String mergeCustomDelimiter(Matcher customDelimiterMatcher) {
        String delimitersText = customDelimiterMatcher.group(1);
        Matcher extractDelimiterMatcher = extractDelimiterPattern.matcher(delimitersText);
        StringBuilder customDelimiters = new StringBuilder();
        while (extractDelimiterMatcher.find()) {
            customDelimiters.append("|").append(extractDelimiterMatcher.group(1));
        }

        return customDelimiters.toString();
    }

    private String skipCustomDelimiter(String numbers) {
        return customDelimiterPattern.split(numbers)[1];
    }

    private static int calculateSumOf(String[] numbers) {
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String n : numbers) {
            int number = Integer.parseInt(n);
            if (number < 0) {
                negatives.add(number);
            }

            if (number <= 1000) {
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            String negativesString = negatives.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new NegativeNumbersNotAllowedException(
                    "negatives not allowed: %s".formatted(negativesString));
        }

        return sum;
    }
}
