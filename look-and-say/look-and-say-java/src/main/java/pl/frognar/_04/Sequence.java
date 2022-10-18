package pl.frognar._04;

public class Sequence {
    public static String lookAndSay(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int index = 0; index < input.length() - 1; index++) {
            char currentDigit = input.charAt(index);
            char nextDigit = input.charAt(index + 1);
            if (currentDigit == nextDigit) {
                count++;
            } else {
                result.append(say(count, currentDigit));
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result.append(say(count, lastDigit));
        return result.toString();
    }

    private static String say(int count, char lastDigit) {
        return "%s%s".formatted(count, lastDigit);
    }

    public static String lookAndSay(String input, int depth) {
        String result = "";
        result += lookAndSay(input);
        return result;
    }
}
