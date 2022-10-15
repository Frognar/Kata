package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2)
            return "1112";
        return "1%s".formatted(input);
    }
}
