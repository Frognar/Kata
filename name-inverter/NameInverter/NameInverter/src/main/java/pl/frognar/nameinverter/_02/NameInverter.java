package pl.frognar.nameinverter._02;

import com.google.common.collect.Lists;

import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespace(name);

        if (nameParts.size() < 2)
            return nameParts.get(0);

        String first = nameParts.get(0);
        String last = nameParts.get(1);

        return String.format("%s, %s", last, first);
    }

    private static List<String> breakIntoPartsIgnoringWhitespace(String name) {
        return Lists.newArrayList(name.trim().split(RegularExpressions.anyAmountOfWhitespace()));
    }
}

class RegularExpressions {
    public static String anyAmountOfWhitespace() {
        return "\\s+";
    }
}
