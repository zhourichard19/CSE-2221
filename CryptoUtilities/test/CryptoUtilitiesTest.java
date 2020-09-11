import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Richard Zhou
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    //tests zero because this is the lowest boundary
    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    //Tests 30 and 21 as routine cases
    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    //tests 5 and 3 because the GCD is 1 which is not a multiple of either.
    //this is a routine and challenge
    @Test
    public void testReduceToGCD_5_3() {
        NaturalNumber n = new NaturalNumber2(5);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(3);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    //Finds the GCD between two numbers that are also one which are slightly
    //larger. This is a challenge
    @Test
    public void testReduceToGCD_22_7() {
        NaturalNumber n = new NaturalNumber2(22);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(7);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    //checks for a larger number which is a challenge and a boundary
    @Test
    public void testReduceToGCD_384_64() {
        NaturalNumber n = new NaturalNumber2(384);
        NaturalNumber nExpected = new NaturalNumber2(64);
        NaturalNumber m = new NaturalNumber2(64);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    //checks to see if the lowest number zero is even. Makes a boundary case
    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    //Checks to see if the lowest odd number is even. This is a boundary case
    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    //Checks to see if a large number is even which is a boundary case
    @Test
    public void testIsEven_10289() {
        NaturalNumber n = new NaturalNumber2(10289);
        NaturalNumber nExpected = new NaturalNumber2(10289);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    //Checks to see if a number is even which is a routine case
    @Test
    public void testIsEven_58() {
        NaturalNumber n = new NaturalNumber2(58);
        NaturalNumber nExpected = new NaturalNumber2(58);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    //Checks to see the power of 0 0 and 2 which is the smallest answer making
    //this a boundary case
    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    //Checks to see the power of 17 18 and 19 which is a normal number making
    //this a routine case
    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    //checks to see if two odd numbers that are small are composites.
    //this is routine and boundary
    @Test
    public void isWitnessToCompositeness_5_7() {
        NaturalNumber w = new NaturalNumber2(5);
        NaturalNumber wExpected = new NaturalNumber2(5);
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(7);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    //Checks to see if two middle numbers are composite.
    //This is a routine case
    public void isWitnessToCompositeness_8_9() {
        NaturalNumber w = new NaturalNumber2(8);
        NaturalNumber wExpected = new NaturalNumber2(8);
        NaturalNumber n = new NaturalNumber2(9);
        NaturalNumber nExpected = new NaturalNumber2(9);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    //Checks to see if two larger numbers are composite.
    //This is a Challenge case
    public void isWitnessToCompositeness_48_79() {
        NaturalNumber w = new NaturalNumber2(48);
        NaturalNumber wExpected = new NaturalNumber2(48);
        NaturalNumber n = new NaturalNumber2(79);
        NaturalNumber nExpected = new NaturalNumber2(79);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of isPrime1
     */

    //Checks to see if a small prime is prime making this boundary
    @Test
    public void isPrime1_5_() {
        NaturalNumber w = new NaturalNumber2(5);
        NaturalNumber wExpected = new NaturalNumber2(5);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    //Checks to see if a reasonable number is prime making this routine
    @Test
    public void isPrime1_8_() {
        NaturalNumber w = new NaturalNumber2(8);
        NaturalNumber wExpected = new NaturalNumber2(8);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }

    //Checks to see if a large number is prime making this boundary and
    //challenge
    @Test
    public void isPrime1_1928_() {
        NaturalNumber w = new NaturalNumber2(1928);
        NaturalNumber wExpected = new NaturalNumber2(1928);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }
    /*
     * Tests of isPrime2
     */

    //Checks to see if a small prime is prime making this boundary
    @Test
    public void isPrime2_5_() {
        NaturalNumber w = new NaturalNumber2(5);
        NaturalNumber wExpected = new NaturalNumber2(5);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    //Checks to see if a reasonable number is prime making this routine
    @Test
    public void isPrime2_8_() {
        NaturalNumber w = new NaturalNumber2(8);
        NaturalNumber wExpected = new NaturalNumber2(8);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }

    //Checks to see if a large number is prime making this boundary and
    //challenge
    @Test
    public void isPrime2_1928_() {
        NaturalNumber w = new NaturalNumber2(1928);
        NaturalNumber wExpected = new NaturalNumber2(1928);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }

    //Checks to see if a large number is prime making this boundary and
    //challenge
    @Test
    public void isPrime2_1929467_() {
        NaturalNumber w = new NaturalNumber2(1929467);
        NaturalNumber wExpected = new NaturalNumber2(1929467);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    /*
     * Tests of generateNextLikelyPrime
     */

    //tests a small odd number that is not prime for a prime
    //this is a boundary and a routine
    @Test
    public void generateNextLikelyPrime_15_() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber wExpected = new NaturalNumber2(17);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    //Tests a number that is even to find the next prime
    //this is routine
    @Test
    public void generateNextLikelyPrime_20_() {
        NaturalNumber w = new NaturalNumber2(20);
        NaturalNumber wExpected = new NaturalNumber2(23);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    //test slightly larger number for being prime
    //this is a routine case
    @Test
    public void generateNextLikelyPrime_270_() {
        NaturalNumber w = new NaturalNumber2(270);
        NaturalNumber wExpected = new NaturalNumber2(271);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    //tests a large number if it is prime or not
    //this is routine and challenge case
    @Test
    public void generateNextLikelyPrime_1929467_() {
        NaturalNumber w = new NaturalNumber2(1929464);
        NaturalNumber wExpected = new NaturalNumber2(1929467);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }
}