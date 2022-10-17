package pl.frognar._03;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2)
            return "2%s".formatted(input.charAt(0));
        else
            return "1%s".formatted(input);
    }
}
