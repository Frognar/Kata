package pl.frognar._02;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                result += "2%s".formatted(input.charAt(0));
                return result;
            }
            else {
                result += "1%s".formatted(input.charAt(0));
                result += "1%s".formatted(input.charAt(1));
            }
        }
        else {
            result += "1%s".formatted(input.charAt(0));
        }

        return result;
    }
}
