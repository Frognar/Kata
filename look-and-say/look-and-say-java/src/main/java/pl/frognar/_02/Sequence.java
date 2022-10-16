package pl.frognar._02;

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
                result.append(say(count, currentDigit));
                count = 1;
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result.append(say(count, lastDigit));
        return result.toString();
    }

    private static String say(int count, char currentDigit) {
        return "%s%s".formatted(count, currentDigit);
    }

    public static String lookAndSay(String input, int depth) {
        String result = "";
        String currentDepth = input;
        for (int i = 0; i < depth; i++) {
            currentDepth = lookAndSay(currentDepth);
            result += currentDepth + " ";
        }

        return result.trim();
    }
}
