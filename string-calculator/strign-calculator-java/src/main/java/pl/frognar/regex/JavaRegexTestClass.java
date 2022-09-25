package pl.frognar.regex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexTestClass {
    public static String replaceAllCustomDelimitersToCommas(String numbers) {
        Pattern customDelimitersPattern = Pattern.compile("//(\\[?.+]?)+\n");
        Matcher multipleMatcher = customDelimitersPattern.matcher(numbers);
        if (multipleMatcher.find()) {
            List<String> delimiters = getAllCustomDelimiters(multipleMatcher.group(0));
            numbers = replaceAllDelimitersWithComma(numbers, delimiters);
            return customDelimitersPattern.split(numbers)[1];
        }

        return numbers;
    }

    private static List<String> getAllCustomDelimiters(String delimitersGroup) {
        String escapedRegex = "\\Q%s\\E";
        delimitersGroup = delimitersGroup.substring(2, delimitersGroup.length() - 1);
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]["), " ");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("["), "");
        delimitersGroup = delimitersGroup.replaceAll(escapedRegex.formatted("]"), "");
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
