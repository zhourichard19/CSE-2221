import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas3.toStringWithCommas(n);
    }

    /**
     * Test toStringWithCommasTest with input 100.
     */
    @Test
    public void toStringWithCommasTest1() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber nExpected = new NaturalNumber2(100);
        String ans = redirectToMethodUnderTest(n);
        String expectedAns = "100";

        assertEquals(nExpected, n);
        assertEquals(expectedAns, ans);
    }

    /**
     * Test aNonTrivialFactorV1 with input 1000.
     */
    @Test
    public void toStringWithCommasTest2() {
        NaturalNumber n = new NaturalNumber2(1000);
        NaturalNumber nExpected = new NaturalNumber2(1000);
        String ans = redirectToMethodUnderTest(n);
        String expectedAns = "1,000";

        assertEquals(nExpected, n);
        assertEquals(expectedAns, ans);
    }

    /**
     * Test aNonTrivialFactorV1 with input 12398.
     */
    @Test
    public void toStringWithCommasTest3() {
        NaturalNumber n = new NaturalNumber2(12398);
        NaturalNumber nExpected = new NaturalNumber2(12398);
        String ans = redirectToMethodUnderTest(n);
        String expectedAns = "12,398";

        assertEquals(nExpected, n);
        assertEquals(expectedAns, ans);
    }

    /**
     * Test aNonTrivialFactorV1 with input 1234567.
     */
    @Test
    public void toStringWithCommasTest4() {
        NaturalNumber n = new NaturalNumber2(1234567);
        NaturalNumber nExpected = new NaturalNumber2(1234567);
        String ans = redirectToMethodUnderTest(n);
        String expectedAns = "1,234,567";

        assertEquals(nExpected, n);
        assertEquals(expectedAns, ans);
    }

    /**
     * Test aNonTrivialFactorV1 with input 5.
     */
    @Test
    public void toStringWithCommasTest5() {
        NaturalNumber n = new NaturalNumber2(5);
        NaturalNumber nExpected = new NaturalNumber2(5);
        String ans = redirectToMethodUnderTest(n);
        String expectedAns = "5";

        assertEquals(nExpected, n);
        assertEquals(expectedAns, ans);
    }

    /**
     * Test toStringWithCommasTest with input 5461300508713.
     */
    @Test
    public void toStringWithCommasTest6() {
        NaturalNumber n = new NaturalNumber2("5461300508713");
        NaturalNumber nExpected = new NaturalNumber2("5461300508713");
        String ans = redirectToMethodUnderTest(n);
        String expectedAns = "5,461,300,508,713";

        assertEquals(nExpected, n);
        assertEquals(expectedAns, ans);
    }
}
