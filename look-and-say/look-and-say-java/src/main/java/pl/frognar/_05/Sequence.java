package pl.frognar._05;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                count++;
                result += "%s%s".formatted(count, input.charAt(0));
                return result;
            }
            else {
                result += "%s%s".formatted(count, input.charAt(0));
                result += "%s%s".formatted(count, input.charAt(1));
                return result;
            }
        }

        result += "%s%s".formatted(count, input.charAt(input.length() - 1));
        return result;
    }
}
