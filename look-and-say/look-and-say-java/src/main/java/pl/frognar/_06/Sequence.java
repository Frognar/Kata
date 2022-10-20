package pl.frognar._06;

public class Sequence {
    public static String lookAndSay(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int index = 0; index < input.length() - 1; index++) {
            char currentDigit = input.charAt(index);
            char nextDigit = input.charAt(index + 1);
            if (currentDigit == nextDigit) {
                count++;
            }
            else {
                result.append("%s%s".formatted(count, currentDigit));
                count = 1;
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result.append("%s%s".formatted(count, lastDigit));
        return result.toString();
    }
}
