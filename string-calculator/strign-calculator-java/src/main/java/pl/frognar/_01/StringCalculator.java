package pl.frognar._01;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numbersList = numbers.split("[,\\n]");
        int sum = 0;
        for (String n: numbersList) {
            sum += Integer.parseInt(n);
        }

        return sum;
    }
}
