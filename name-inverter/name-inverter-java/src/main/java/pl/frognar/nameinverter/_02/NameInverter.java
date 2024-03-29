package pl.frognar.nameinverter._02;

import com.google.common.collect.Lists;

import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespace(name);
        if (nameParts.size() < 2)
            return nameParts.get(0);
        return invert(withoutHonorifics(nameParts));
    }

    private static List<String> breakIntoPartsIgnoringWhitespace(String name) {
        return Lists.newArrayList(name.trim().split(RegularExpressions.anyAmountOfWhitespace()));
    }

    private static List<String> withoutHonorifics(List<String> nameParts) {
        if (Honorifics.isHonorific(nameParts.get(0)))
            nameParts.remove(0);
        return nameParts;
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);
        String postnominals = findAndMergePostnominals(nameParts);
        return String.format("%s, %s %s", last, first, postnominals).trim();
    }

    private static String findAndMergePostnominals(List<String> nameParts) {
        StringBuilder postnominals = new StringBuilder();
        for (String np : nameParts.subList(2, nameParts.size()))
            postnominals.append(np).append(" ");
        return postnominals.toString();
    }
}

class RegularExpressions {
    public static String anyAmountOfWhitespace() {
        return "\\s+";
    }
}

class Honorifics {
    private static final List<String> knownHonorifics = List.of("Mr.");

    public static boolean isHonorific(String s) {
        return knownHonorifics.contains(s);
    }
}