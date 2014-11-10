package algorithms.max;

import org.junit.Test;

/**
 * Created by nanagarajan on 11/5/2014.
 */
public class MaxOccurenceTest {

    @Test(expected = RuntimeException.class)
    public void testNullString() {
        String input = null;
        MaxOccurence.getMaxOccurances(input);
    }

    @Test
    public void testWithOnlyOneChar() {
        String input = "a";
        char out = MaxOccurence.getMaxOccurances(input);
        assert out == input.charAt(0);
    }

    @Test
    public void testMaxOccurrenceWithOnlyOnePossibleMaxChar() {
        String input = "aaabcdef";
        char out = MaxOccurence.getMaxOccurances(input);
        assert out == 'a';
    }

    @Test
    public void testMaxOccurrenceWithOneMaxChar() {
        String input = "aaabbcdef";
        char out = MaxOccurence.getMaxOccurances(input);
        assert out == 'a';
    }

    @Test(expected = RuntimeException.class)
    public void testMaxOccurrenceWithTwoMaxChar() {
        String input = "aabbcdef";
        MaxOccurence.getMaxOccurances(input);

    }


}
