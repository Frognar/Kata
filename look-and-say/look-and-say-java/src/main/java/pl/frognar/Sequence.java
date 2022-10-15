package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        var result = "";
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                var count = 2;
                result += "%s%s".formatted(count, input.charAt(0));
            }
            else {
                var count = 1;
                result += "%s%s".formatted(count, input.charAt(0));
                result += "%s%s".formatted(count, input.charAt(1));
            }
        }
        else {
            var count = 1;
            result += "%s%s".formatted(count, input.charAt(0));
        }

        return result;
    }
}
