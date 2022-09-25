package pl.frognar._02;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiters = "[,\n]";
        if (numbers.startsWith("//")) {
            delimiters += "|" + numbers.charAt(2);
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }
        var numbersList = numbers.split(delimiters);
        return Arrays.stream(numbersList).map(Integer::parseInt).reduce(0, Integer::sum);
    }
}
