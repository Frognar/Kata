package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        var result = "";
        var count = 1;
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                count++;
            }
            else {
                result += "%s%s".formatted(count, input.charAt(0));
                count = 1;
            }

            result += "%s%s".formatted(count, input.charAt(input.length() - 1));
        }
        else {
            result += "%s%s".formatted(count, input.charAt(input.length() - 1));
        }

        return result;
    }
}
