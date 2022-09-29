package pl.frognar._06;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numberList = splitAndConvertNumbers(numbers);
        return calculateSumOf(numberList);
    }


    private static final String delimiter = ",";
    private List<Integer> splitAndConvertNumbers(String numbers) {
        return Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    private int calculateSumOf(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
