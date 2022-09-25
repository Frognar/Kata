package pl.frognar._02;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        numbers = numbers.replaceAll("[^0-9]", ",");
        String delimiters = ",";
        var numbersList = Arrays.stream(numbers.split(delimiters)).filter(s -> !s.isEmpty());
        return numbersList.map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
