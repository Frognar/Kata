package pl.frognar._07;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        if (input.length() == 2) {
            char currentDigit = input.charAt(0);
            if (currentDigit == input.charAt(1)) {
                count++;
            } else {
                result += "%s%s".formatted(count, currentDigit);
            }
        }
        result += "%s%s".formatted(count, input.charAt(input.length() - 1));
        return result;
    }
}
