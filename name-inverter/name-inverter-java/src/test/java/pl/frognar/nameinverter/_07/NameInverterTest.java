package pl.frognar.nameinverter._07;

import org.junit.Ignore;
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

    @Test
    public void invert_whitespaces_shouldReturnEmpty() {
        assertThat(NameInverter.invert("    "), is(""));
    }

    @Test
    public void invert_first_shouldReturnFirst() {
        assertThat(NameInverter.invert("John"), is("John"));
    }

    @Ignore
    @Test
    public void invert_firstLast_shouldReturnLastCommaFirst() {
        assertThat(NameInverter.invert("John Smith"), is("Smith, John"));
    }
}
