package pl.frognar._06;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        var numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
        return calculateSumOf(numberList);
    }


    private int calculateSumOf(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
