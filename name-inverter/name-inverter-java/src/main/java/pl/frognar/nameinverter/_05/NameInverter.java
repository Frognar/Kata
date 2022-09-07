package pl.frognar.nameinverter._05;

import com.google.common.collect.Lists;

import java.util.List;

public class NameInverter {
    public static String invert(String name) {
        List<String> nameParts = Lists.newArrayList(name.trim().split(" "));
        String first = nameParts.get(0);
        return String.format("%s", first);
    }
}
