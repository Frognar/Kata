package pl.frognar._05;

public class Sequence {
    public static String lookAndSay(String input) {
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                String result = "";
                result += "2%s".formatted(input.charAt(0));
                return result;
            }
            else {
                String result = "";
                result += "1%s1%s".formatted(input.charAt(0), input.charAt(1));
                return result;
            }
        }
        return "1%s".formatted(input);
    }
}
