package pl.frognar.nameinverter._07;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class NameInverterTest {
    @Test(expected = NullPointerException.class)
    public void invert_null_shouldThrowNullPointerException() {
        NameInverter.invert(null);
    }

    @Test
    public void invert_empty_shouldReturnEmpty() {
        assertThat(NameInverter.invert(""), is(""));
    }
}
