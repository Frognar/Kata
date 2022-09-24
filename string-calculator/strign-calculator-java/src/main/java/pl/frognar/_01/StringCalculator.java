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

    private static final String startOfCustomDelimiter = "//";
    private static boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith(startOfCustomDelimiter);
    }

    private static final char endOfCustomDelimiter = '\n';
    private static String getCustomDelimiter(String numbers) {
        return "(%s)".formatted(numbers.substring(2, numbers.indexOf(endOfCustomDelimiter)));
    }

    private static String skipCustomDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf(endOfCustomDelimiter) + 1);
    }
}
