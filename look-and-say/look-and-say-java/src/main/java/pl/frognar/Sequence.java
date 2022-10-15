package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        var result = "";
        var count = 1;
        for (var index = 0; index < input.length() - 1; index++) {
            var currentDigit = input.charAt(index);
            var nextDigit = input.charAt(index + 1);
            if (currentDigit == nextDigit) {
                count++;
            }
            else {
                result += say(count, currentDigit);
                count = 1;
            }
        }

        result += say(count, input.charAt(input.length() - 1));
        return result;
    }

    private static String say(int count, char currentDigit) {
        return "%s%s".formatted(count, currentDigit);
    }
}
