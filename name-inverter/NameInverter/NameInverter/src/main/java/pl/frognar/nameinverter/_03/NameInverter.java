package pl.frognar.nameinverter._03;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespaces(name);
        if (nameParts.size() < 2)
            return nameParts.get(0);
        return invert(nameParts);
    }

    private static ArrayList<String> breakIntoPartsIgnoringWhitespaces(String name) {
        return Lists.newArrayList(name.trim().split(" "));
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);
        return String.format("%s, %s", last, first);
    }
}
