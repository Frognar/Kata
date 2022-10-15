package pl.frognar;

public class Sequence {
    public static String lookAndSay(String input) {
        var result = "";
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                result += "2%s".formatted(input.charAt(0));
                return result;
            }
            else {
                result += "1%s".formatted(input.charAt(0));
                result += "1%s".formatted(input.charAt(1));
                return result;
            }
        }
        else {
            result += "1%s".formatted(input.charAt(0));
        }

        return result;
    }
}
