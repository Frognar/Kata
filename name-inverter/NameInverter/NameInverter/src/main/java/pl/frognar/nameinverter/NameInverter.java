package pl.frognar.nameinverter;

import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespace(name);

        if (nameParts.size() < 2)
            return nameParts.get(0);

        return invert(nameParts);
    }

    private static List<String> breakIntoPartsIgnoringWhitespace(String name) {
        return List.of(name.trim().split(RegularExpressions.anyAmountOfWhitespace()));
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);

        return String.format("%s, %s", last, first);
    }
}

class RegularExpressions {
    public static String anyAmountOfWhitespace() {
        return "\\s+";
    }
}