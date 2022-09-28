package pl.frognar._05;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt);
        return calculateSumOf(numberList);
    }

    private int calculateSumOf(Stream<Integer> numbers) {
        return numbers.reduce(0, Integer::sum);
    }
}
