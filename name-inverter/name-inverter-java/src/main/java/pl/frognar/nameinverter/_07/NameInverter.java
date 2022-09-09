package pl.frognar.nameinverter._07;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespaces(name);
        if (nameParts.size() < 2)
            return nameParts.get(0);
        return invert(withoutHonorifics(nameParts));
    }

    private static ArrayList<String> breakIntoPartsIgnoringWhitespaces(String name) {
        return Lists.newArrayList(name.trim().split(RegularExpressions.anyAmountOfWhitespaces()));
    }

    private static List<String> withoutHonorifics(List<String> nameParts) {
        if (Honorifics.isHonorific(nameParts.get(0)))
            nameParts.remove(0);
        return nameParts;
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);
        String postnominals = FindAndMergePostnominals(nameParts);
        return String.format("%s, %s %s", last, first, postnominals).trim();
    }

    private static String FindAndMergePostnominals(List<String> nameParts) {
        String postnominals = "";
        for (String np : nameParts.subList(2, nameParts.size()))
            postnominals += np + " ";
        return postnominals;
    }
}

class RegularExpressions {
    public static String anyAmountOfWhitespaces() {
        return "\\s+";
    }
}

class Honorifics {
    private static final List<String> knownHonorifics = List.of("Mr.", "Mrs.");

    public static boolean isHonorific(String s) {
        return knownHonorifics.contains(s);
    }
}