package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        var result = "";
        var count = 1;
        var index = 0;
        if (input.length() == 2) {
            if (input.charAt(index) == input.charAt(index + 1)) {
                count++;
            }
            else {
                result += "%s%s".formatted(count, input.charAt(index));
                count = 1;
            }
        }

        result += "%s%s".formatted(count, input.charAt(input.length() - 1));
        return result;
    }
}
