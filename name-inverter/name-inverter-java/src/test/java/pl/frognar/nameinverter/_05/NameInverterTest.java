package pl.frognar.nameinverter._05;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class NameInverterTest {
    @Test(expected = NullPointerException.class)
    public void invert_null_shouldThrowNullPointerException() {
        NameInverter.invert(null);
    }
}
