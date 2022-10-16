package pl.frognar._02;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        if (input.length() == 2) {
            char currentDigit = input.charAt(0);
            char nextDigit = input.charAt(1);
            if (currentDigit == nextDigit) {
                count++;
            }
            else {
                result += "%s%s".formatted(count, currentDigit);
                count = 1;
            }
        }

        result += "%s%s".formatted(count, input.charAt(input.length() - 1));
        return result;
    }
}
