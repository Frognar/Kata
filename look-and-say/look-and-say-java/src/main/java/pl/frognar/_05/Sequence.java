package pl.frognar._05;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2)
            return "2%s".formatted(input.charAt(0));
        return "1%s".formatted(input);
    }
}
