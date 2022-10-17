package pl.frognar._03;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                return "2%s".formatted(input.charAt(0));
            } else {
                return "1%s1%s".formatted(input.charAt(0), input.charAt(1));
            }
        } else {
            return "1%s".formatted(input);
        }
    }
}
