package pl.frognar._02;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        int count = 1;
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                count++;
                result += "%s%s".formatted(count, input.charAt(0));
            }
            else {
                result += "%s%s".formatted(count, input.charAt(0));
                count = 1;
                result += "%s%s".formatted(count, input.charAt(1));
            }
        }
        else {
            result += "%s%s".formatted(count, input.charAt(0));
        }

        return result;
    }
}
