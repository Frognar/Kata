package pl.frognar._05;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numberList = splitAndConvertNumbers(numbers);
        var negatives = numberList.stream().filter(n -> n < 0);
        if (negatives.findAny().isPresent()) {
            throw new NegativeNumbersNotAllowedException("negatives not allowed: -1");
        }

        return calculateSumOf(numberList);
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
