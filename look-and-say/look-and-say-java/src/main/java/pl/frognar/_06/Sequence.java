package pl.frognar._06;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        int index = 0;
        if (input.length() == 2) {
            char currentDigit = input.charAt(index);
            char nextDigit = input.charAt(1);
            if (currentDigit == nextDigit) {
                count++;
            }
            else {
                result += "%s%s".formatted(count, currentDigit);
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result += "%s%s".formatted(count, lastDigit);
        return result;
    }
}
