package pl.frognar._04;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        for(int index = 0; index < input.length() - 1; index++) {
            char currentDigit = input.charAt(index);
            char nextDigit = input.charAt(index + 1);
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
