package pl.frognar._07;

public class Sequence {
    public static String lookAndSay(String input) {
        String result = "";
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) {
                int count = 1;
                count++;
                result += "%s%s".formatted(count, input.charAt(0));
                return result;
            }
            int count = 1;
            result += "%s%s".formatted(count, input.charAt(0));
            result += "1%s".formatted(input.charAt(1));
            return result;
        }
        result += "1%s".formatted(input);
        return result;
    }
}
