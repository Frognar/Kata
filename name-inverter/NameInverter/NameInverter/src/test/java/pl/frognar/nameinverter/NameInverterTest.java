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

    @Test
    public void invert_firstLast_shouldReturnLastCommaFirst() {
        assertThat(NameInverter.invert("John Smith"), is("Smith, John"));
        assertThat(NameInverter.invert("John   Smith"), is("Smith, John"));
    }

    @Test
    public void invert_honorificsFirstLast_shouldReturnLastCommaFirst() {
        assertThat(NameInverter.invert("Mr. John Smith"), is("Smith, John"));
        assertThat(NameInverter.invert("Mrs. John Smith"), is("Smith, John"));
    }

    @Test
    public void invert_firstLastPostnominals_shouldReturnLastCommaFirstPostnominals() {
        assertThat(NameInverter.invert("John Smith Sr."), is("Smith, John Sr."));
    }
}
