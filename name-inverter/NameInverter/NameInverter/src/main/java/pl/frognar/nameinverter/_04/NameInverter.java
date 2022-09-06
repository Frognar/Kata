package pl.frognar.nameinverter._04;

import com.google.common.collect.Lists;

import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespaces(name);
        if (nameParts.size() < 2)
            return nameParts.get(0);
        return invert(ignoreHonorifics(nameParts));
    }

    private static List<String> breakIntoPartsIgnoringWhitespaces(String name) {
        return Lists.newArrayList(name.trim().split(RegularExpressions.anyAmountOfWhiteSpaces()));
    }

    private static List<String> ignoreHonorifics(List<String> nameParts) {
        if (Honorifics.isHonorific(nameParts.get(0)))
            nameParts.remove(0);
        return nameParts;
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);
        return String.format("%s, %s", last, first);
    }
}

class RegularExpressions {
    public static String anyAmountOfWhiteSpaces() {
        return "\\s+";
    }
}

class Honorifics {
    private static final List<String> knownHonorifics = List.of("Mr.", "Mrs.");

    public static boolean isHonorific(String s) {
        return knownHonorifics.contains(s);
    }
}