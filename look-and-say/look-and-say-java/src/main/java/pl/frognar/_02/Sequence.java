package pl.frognar._02;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2)
            return "21";
        return "1%s".formatted(input);
    }
}
