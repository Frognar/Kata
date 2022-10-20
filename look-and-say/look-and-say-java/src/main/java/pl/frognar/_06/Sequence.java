package pl.frognar._06;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        for (int index = 0; index < input.length() - 1; index++) {
            if (input.length() > 1) {
                char currentDigit = input.charAt(index);
                char nextDigit = input.charAt(index + 1);
                if (currentDigit == nextDigit) {
                    count++;
                }
                else {
                    result += "%s%s".formatted(count, currentDigit);
                }
            }
        }

        char lastDigit = input.charAt(input.length() - 1);
        result += "%s%s".formatted(count, lastDigit);
        return result;
    }
}
