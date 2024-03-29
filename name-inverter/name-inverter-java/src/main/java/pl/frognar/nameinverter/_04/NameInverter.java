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
        String postnominal = findAndMergePostnominals(nameParts);
        return String.format("%s, %s %s", last, first, postnominal).trim();
    }

    private static String findAndMergePostnominals(List<String> nameParts) {
        StringBuilder postnominal = new StringBuilder();
        for (String np : nameParts.subList(2, nameParts.size()))
            postnominal.append(np).append(" ");
        return postnominal.toString();
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