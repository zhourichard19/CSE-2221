import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Richard Zhou
 *
 */
public class StringReassemblyTest {

    /*
     * Tests of overlap
     */

    //tests zero because this is the lowest boundary
    @Test
    public void testOverlap() {
        String str1 = "theohiostate";
        String str2 = "stateuniversity";
        int result = 5;
        int testRes = StringReassembly.overlap(str1, str2);
        assertEquals(result, testRes);
    }
    /*
     * Tests of overlap
     */

    //tests a larger number which makes this a routine challenge
    @Test
    public void testOverlap2() {
        String str1 = "theelephant";
        String str2 = "elephanthasabigleg";
        int result = 8;
        int testRes = StringReassembly.overlap(str1, str2);
        assertEquals(result, testRes);
    }

    /**
     * Routine test of combination.
     */
    //Tests  for the return value of 4 from the overlap
    @Test
    public void testCombination1() {
        String str1 = "removethis";
        String str2 = "thisshouldberemoved";
        int overlap = 4;
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals("removethisshouldberemoved", result);
    }

    /**
     * Routine test of combination tests to see if the strings are the same
     * which is a routine and challenge
     */
    // tests for the return value of 7 from the overlap
    @Test
    public void testCombination2() {
        String str1 = "forreal";
        String str2 = "forreal";
        int overlap = 7;
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals("forreal", result);
    }

    /**
     * test of combination. tests to see if it works for one letter which makes
     * the test a routine boundary
     */
    // tests for the return value of 1 from the overlap
    @Test
    public void testCombination3() {
        String str1 = "oneletter";
        String str2 = "rlebron";
        int overlap = 1;
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals("oneletterlebron", result);
    }

    /**
     * test of addToSetAvoidingSubstrings. this is a routine test because the
     * code is just checking what it should be doing
     */
    //Checks to make sure that two same strings are the same without substrings
    @Test
    public void testaddToSetAvoidingSubstrings() {
        Set<String> strset = new Set1L<String>();
        strset.add("heyman");
        strset.add("the sun is up");
        strset.add("lets play ball");
        Set<String> strset2 = new Set1L<String>();
        strset2.add("heyman");
        strset2.add("the sun is up");
        strset2.add("lets play ball");
        String str = "play";
        StringReassembly.addToSetAvoidingSubstrings(strset, str);
        assertEquals(strset, strset2);
    }

    /**
     * test of addToSetAvoidingSubstrings. this tests for the is there are
     * different words in the set of strings which means it is a challenge test
     */
    //Checks to make sure that two similar strings are the
    //are different without substrings
    @Test
    public void testaddToSetAvoidingSubstrings2() {
        Set<String> strset = new Set1L<String>();
        strset.add("the food");
        strset.add("is pretty good");
        strset.add("try some");
        Set<String> strset2 = new Set1L<String>();
        strset2.add("the food");
        strset2.add("is pretty good");
        strset2.add("try some");
        strset2.add("Ricky");
        String str = "Ricky";
        StringReassembly.addToSetAvoidingSubstrings(strset, str);
        assertEquals(strset, strset2);
    }

    @Test
    /**
     * test of printWithLineSeparatorsTest1. tests a string with multiple ~ so
     * it is a challenge and a routine
     */
    //checks to make sure all of the ~ are replaced by " "
    public void printWithLineSeparatorsTest1() {
        SimpleWriter out = new SimpleWriter1L();
        String test1 = "I ~ am ~ a ~ student ~ here";

        StringReassembly.printWithLineSeparators(test1, out);

        out.close();
    }

    @Test
    /**
     * test of printWithLineSeparatorsTest1 only tests for one ~ so it is a
     * boundary and a routine
     */
    //checks to make sure all of the ~ are replaced by " "
    public void printWithLineSeparatorsTest2() {
        SimpleWriter out = new SimpleWriter1L();
        String test1 = "I am a student ~ at tOSU";

        StringReassembly.printWithLineSeparators(test1, out);

        out.close();
    }

    @Test
    /**
     * test of linesFromInput tests to make sure that the lines are correct This
     * would be a routine and challenge because there are multiple lines being
     * checked
     */
    //Checks to see that the file involved and returned after running through
    // the method is the same as the expected String. This is with the the
    //strings with substrings removed
    public void linesFromInputTest1() {
        Set<String> expected = new Set1L<>();
        expected.add("Bucks -- Beat");
        expected.add("Go Bucks");
        expected.add("o Bucks -- B");
        expected.add("Beat Mich");
        expected.add("Michigan~");

        SimpleWriter out = new SimpleWriter1L();
        SimpleReader input = new SimpleReader1L("data/cheers.txt");
        Set<String> strSet = StringReassembly.linesFromInput(input);

        input.close();
        assertEquals(expected, strSet);
    }

}