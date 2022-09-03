package pl.frognar.nameinverter;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Ignore;
import org.junit.Test;

public class NameInverterTest {
    @Test(expected = NullPointerException.class)
    public void invert_null_shouldThrowNullPointerException() {
        NameInverter.invert(null);
    }

    @Test
    public void invert_empty_shouldReturnEmpty() {
        assertThat(NameInverter.invert(""), is(""));
        assertThat(NameInverter.invert("     "), is(""));
    }

    @Test
    public void invert_firstName_shouldReturnFirstName() {
        assertThat(NameInverter.invert("John"), is("John"));
    }

    @Ignore
    @Test
    public void invert_firstLast_shouldReturnLastComaFirst() {
        assertThat(NameInverter.invert("John Smith"), is("Smith, John"));
    }
}
