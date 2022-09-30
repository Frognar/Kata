package pl.frognar._07;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numbersList = splitAndConvertNumbers(numbers);
        var negatives = numbersList.stream().filter(n -> n < 0).toList();
        if (!negatives.isEmpty()) {
            throw new NegativeNumbersNotAllowedException("negatives not allowed: -1");
        }
        return calculateSumOfNumbers(numbersList);
    }

    private static final String defaultDelimiters = "[,\n]";
    private static List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters))
                .map(Integer::parseInt).toList();
    }

    private static int calculateSumOfNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
