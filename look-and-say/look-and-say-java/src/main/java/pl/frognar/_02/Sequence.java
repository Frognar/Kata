package pl.frognar._02;

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
                result += say(count, currentDigit);
                count = 1;
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result += say(count, lastDigit);
        return result;
    }

    private static String say(int count, char currentDigit) {
        return "%s%s".formatted(count, currentDigit);
    }
}
