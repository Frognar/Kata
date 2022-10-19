package pl.frognar._05;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        int index = 0;
        if (input.length() > 1) {
            char currentDigit = input.charAt(index);
            char nextDigit = input.charAt(index + 1);
            if (currentDigit == nextDigit) {
                count++;
            }
            else {
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
