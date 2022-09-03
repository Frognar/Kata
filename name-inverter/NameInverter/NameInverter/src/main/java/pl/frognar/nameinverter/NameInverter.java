package pl.frognar.nameinverter;

public class NameInverter {
    public static String invert(String name) {
        String first = name.trim();
        return String.format("%s", first);
    }
}
