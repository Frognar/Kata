package pl.frognar._01;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiters = "[,\\n]";
        if (numbers.startsWith("//")) {
            int indexOfCustomDelimiterEnd = numbers.indexOf('\n');
            String customDelimiter = numbers.substring(2, indexOfCustomDelimiterEnd);
            delimiters = "[" + customDelimiter + delimiters.substring(1);
            numbers = numbers.substring(indexOfCustomDelimiterEnd + 1);
        }

        String[] numbersList = numbers.split(delimiters);
        int sum = 0;
        for (String n: numbersList) {
            sum += Integer.parseInt(n);
        }

        return sum;
    }
}
