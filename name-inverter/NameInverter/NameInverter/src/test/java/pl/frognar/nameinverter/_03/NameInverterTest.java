package pl.frognar.nameinverter._03;

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
    public void invert_multipleWhitespaces_shouldReturnEmpty() {
        assertThat(NameInverter.invert("        "), is(""));
    }
}
