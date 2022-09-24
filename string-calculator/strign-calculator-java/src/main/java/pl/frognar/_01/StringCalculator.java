package pl.frognar._01;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiters = "[,\\n]";
        if (hasCustomDelimiter(numbers)) {
            delimiters += "|%s".formatted(getCustomDelimiter(numbers));
            numbers = skipCustomDelimiter(numbers);
        }

        String[] numbersList = numbers.split(delimiters);
        int sum = 0;
        for (String n: numbersList) {
            sum += Integer.parseInt(n);
        }

        return sum;
    }

    private boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private String getCustomDelimiter(String numbers) {
        return "(%s)".formatted(numbers.substring(2, numbers.indexOf('\n')));
    }

    private String skipCustomDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf('\n') + 1);
    }
}
