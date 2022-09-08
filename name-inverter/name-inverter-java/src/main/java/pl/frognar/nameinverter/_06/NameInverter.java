package pl.frognar.nameinverter._06;

import com.google.common.collect.Lists;

import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = Lists.newArrayList(name.trim().split(anyAmountOfWhitespaces()));
        if (nameParts.size() < 2)
            return nameParts.get(0);
        String first = nameParts.get(0);
        String last = nameParts.get(1);
        return String.format("%s, %s", last, first);
    }

    private static String anyAmountOfWhitespaces() {
        return "\\s+";
    }
}
