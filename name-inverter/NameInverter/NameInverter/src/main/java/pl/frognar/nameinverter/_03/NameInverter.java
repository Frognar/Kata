package pl.frognar.nameinverter._03;

public class NameInverter {
    public static String invert(String name) {
        String first = name.trim();
        return String.join("%s", first);
    }
}
