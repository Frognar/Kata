package pl.frognar.nameinverter._07;

public class NameInverter {
    public static String invert(String name) {
        if (name == null)
            throw new NullPointerException();
        return name.trim();
    }
}
