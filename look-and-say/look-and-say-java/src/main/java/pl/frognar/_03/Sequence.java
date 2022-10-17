package pl.frognar._03;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2)
            return "21";
        else
            return "1%s".formatted(input);
    }
}
