package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2)
            return "1%s1%s".formatted(input.charAt(0), input.charAt(1));
        return "1%s".formatted(input.charAt(0));
    }
}
