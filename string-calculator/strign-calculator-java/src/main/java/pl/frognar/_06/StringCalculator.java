package pl.frognar._06;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;
        return Integer.parseInt(numbers);
    }
}
