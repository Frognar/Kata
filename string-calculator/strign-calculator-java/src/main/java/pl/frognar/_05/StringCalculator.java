package pl.frognar._05;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numberList = splitAndConvertNumbers(numbers).toList();
        var negatives = numberList.stream().filter(n -> n < 0);
        if (negatives.findAny().isPresent()) {
            throw new NegativeNumbersNotAllowedException("negatives not allowed: -1");
        }

        return calculateSumOf(numberList.stream());
    }

    private static final String defaultDelimiters = "[,\n]";
    private static Stream<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(defaultDelimiters))
                .map(Integer::parseInt);
    }

    private static int calculateSumOf(Stream<Integer> numbers) {
        return numbers.reduce(0, Integer::sum);
    }
}
