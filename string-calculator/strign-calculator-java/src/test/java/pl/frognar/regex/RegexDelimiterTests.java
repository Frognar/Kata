package pl.frognar.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.frognar.regex.JavaRegexTestClass.replaceAllCustomDelimitersToCommas;

public class RegexDelimiterTests {
    @Test
    public void replaceCustomDelimitersWithCommas() {
        assertEquals("1,2,3", replaceAllCustomDelimitersToCommas("1,2,3"));
        assertEquals("1,2,3", replaceAllCustomDelimitersToCommas("//;\n1;2,3"));
        assertEquals("1,2\n3", replaceAllCustomDelimitersToCommas("//;\n1;2\n3"));
        assertEquals("1,2\n3", replaceAllCustomDelimitersToCommas("//[;]\n1;2\n3"));
        assertEquals("1,2,3", replaceAllCustomDelimitersToCommas("//[;;]\n1;;2;;3"));
        assertEquals("1,2,3", replaceAllCustomDelimitersToCommas("//[;][+]\n1;2+3"));
        assertEquals("1,2,3", replaceAllCustomDelimitersToCommas("//[;;][+]\n1;;2+3"));
        assertEquals("1,2,3,4", replaceAllCustomDelimitersToCommas("//[;;][g][***]\n1;;2g3***4"));
        assertEquals("1,2,3,*4", replaceAllCustomDelimitersToCommas("//[;;][g][***]\n1;;2g3****4"));
        assertEquals("1,2,3,4", replaceAllCustomDelimitersToCommas("//[;;][g][***][***+]\n1;;2g3***+4"));
    }
}
