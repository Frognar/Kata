package pl.frognar.nameinverter._05;

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
        if ("Mr.".equals(nameParts.get(0)))
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
    public static String anyAmountOfWhitespaces() {
        return "\\s+";
    }
}
