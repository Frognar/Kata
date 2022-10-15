package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        StringBuilder result = new StringBuilder();
        var count = 1;
        for (var index = 0; index < input.length() - 1; index++) {
            var currentDigit = input.charAt(index);
            var nextDigit = input.charAt(index + 1);
            if (currentDigit == nextDigit) {
                count++;
            }
            else {
                result.append(say(count, currentDigit));
                count = 1;
            }
        }

        var lastDigit = input.charAt(input.length() - 1);
        result.append(say(count, lastDigit));
        return result.toString();
    }

    private static String say(int count, char currentDigit) {
        return "%s%s".formatted(count, currentDigit);
    }

    public static String lookAndSay(String input, int depth) {
        StringBuilder result = new StringBuilder();
        String currentInSequence = input;
        for (int i = 0; i < depth; i++) {
            currentInSequence = lookAndSay(currentInSequence);
            result.append(currentInSequence).append(" ");
        }
        return result.toString().trim();
    }
}
