package pl.frognar.nameinverter._05;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

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
        assertThat(NameInverter.invert("   "), is(""));
    }

    @Test
    public void invert_name_shouldReturnName() {
        assertThat(NameInverter.invert("John"), is("John"));
    }

    @Test
    public void invert_firstLast_shouldReturnLastCommaFirst() {
        assertThat(NameInverter.invert("John Smith"), is("Smith, John"));
    }

    @Test
    public void invert_firstWhitespacesLast_shouldReturnLastCommaFirst() {
        assertThat(NameInverter.invert("John    Smith"), is("Smith, John"));
    }

    @Test
    public void invert_honorificFirstLast_shouldReturnLastCommaFirst() {
        assertThat(NameInverter.invert("Mr. John Smith"), is("Smith, John"));
        assertThat(NameInverter.invert("Mrs. John Smith"), is("Smith, John"));
    }

    @Test
    public void invert_FirstLastPostnominal_shouldReturnLastCommaFirstPostnominal() {
        assertThat(NameInverter.invert("John Smith Sr."), is("Smith, John Sr."));
    }

    @Test
    public void invert_FirstLastPostnominals_shouldReturnLastCommaFirstPostnominals() {
        assertThat(NameInverter.invert("John Smith Sr. PhD."), is("Smith, John Sr. PhD."));
    }

    @Test
    public void finalTest() {
        assertThat(NameInverter.invert("    John     Smith   Sr.    PhD.    "), is("Smith, John Sr. PhD."));
    }
}
