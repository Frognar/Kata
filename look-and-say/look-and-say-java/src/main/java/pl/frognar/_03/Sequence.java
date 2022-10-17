package pl.frognar._03;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        if (input.length() == 2) {
            char currentDigit = input.charAt(0);
            char nextDigit = input.charAt(1);
            if (currentDigit == nextDigit) {
                count++;
            } else {
                result += say(count, currentDigit);
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result += say(count, lastDigit);
        return result;
    }

    private static String say(int count, char lastDigit) {
        return "%s%s".formatted(count, lastDigit);
    }
}
