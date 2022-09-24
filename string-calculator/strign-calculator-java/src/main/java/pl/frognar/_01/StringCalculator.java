package pl.frognar._01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiters = "[,\\n]";
        if (hasCustomDelimiter(numbers)) {
            delimiters += "|%s".formatted(getCustomDelimiter(numbers));
            numbers = skipCustomDelimiter(numbers);
        }

        return calculateSumOf(numbers.split(delimiters));
    }

    private static final String startOfCustomDelimiter = "//";
    private static boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith(startOfCustomDelimiter);
    }

    private static final char endOfCustomDelimiter = '\n';
    private static String getCustomDelimiter(String numbers) {
        return "(%s)".formatted(numbers.substring(2, numbers.indexOf(endOfCustomDelimiter)));
    }

    private static String skipCustomDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf(endOfCustomDelimiter) + 1);
    }

    private static int calculateSumOf(String[] numbers) {
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String n : numbers) {
            int number = Integer.parseInt(n);
            if (number < 0) {
                negatives.add(number);
            }

            sum += number;
        }

        if (!negatives.isEmpty()) {
            String negativesString = negatives.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new NegativeNumbersNotAllowedException(
                    "negatives not allowed: %s".formatted(negativesString));
        }

        return sum;
    }
}
