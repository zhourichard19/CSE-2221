import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program with implementation of {@code NaturalNumber} secondary operation
 * {@code root} implemented as static method.
 *
 * @author Jimmy Eisenhauer
 *
 */
public final class IntervalHalvingSolution {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private IntervalHalvingSolution() {
    }

    /**
     * Updates {@code n} to the {@code r}-th root of its incoming value.
     *
     * @param n
     *            the number whose root to compute
     * @param r
     *            root
     * @updates n
     * @requires r >= 2
     * @ensures n ^ (r) <= #n < (n + 1) ^ (r)
     */
    public static void root(NaturalNumber n, int r, NaturalNumber tooHigh,
            NaturalNumber lowEnough) {
        assert n != null : "Violation of: n is  not null";
        assert r >= 2 : "Violation of: r >= 2";

        // Initializes 1 and 2, will be used later
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);

        // Initializes the difference between tooHigh and lowEnough
        NaturalNumber difference = new NaturalNumber2();
        difference.copyFrom(tooHigh);
        difference.subtract(lowEnough);

        // If statement checks to see if the interval size is one
        if (difference.compareTo(one) == 0) {
            n.copyFrom(lowEnough);
        } else {
            // Initializes a guess which is the average of tooHigh and lowEnough
            NaturalNumber guess = new NaturalNumber2(tooHigh);
            guess.add(lowEnough);
            guess.divide(two);

            // Creating a copy of guess to raise to a power without losing our guess value
            NaturalNumber guessPower = new NaturalNumber2(guess);
            guessPower.power(r);

            // Checks if value is too high or too low and stores it into respective variable
            if (guessPower.compareTo(n) > 0) {
                tooHigh.copyFrom(guess);
            } else {
                lowEnough.copyFrom(guess);
            }

            // Enters the method again until finding a difference of one
            root(n, r, tooHigh, lowEnough);
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        final String[] numbers = { "0", "1", "13", "1024", "189943527", "0",
                "1", "13", "4096", "189943527", "0", "1", "13", "1024",
                "189943527", "82", "82", "82", "82", "82", "9", "27", "81",
                "243", "143489073", "2147483647", "2147483648",
                "9223372036854775807", "9223372036854775808",
                "618970019642690137449562111",
                "162259276829213363391578010288127",
                "170141183460469231731687303715884105727" };
        final int[] roots = { 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 15, 15, 15, 15, 15,
                2, 3, 4, 5, 15, 2, 3, 4, 5, 15, 2, 2, 3, 3, 4, 5, 6 };
        final String[] results = { "0", "1", "3", "32", "13782", "0", "1", "2",
                "16", "574", "0", "1", "1", "1", "3", "9", "4", "3", "2", "1",
                "3", "3", "3", "3", "3", "46340", "46340", "2097151", "2097152",
                "4987896", "2767208", "2353973" };

        for (int i = 0; i < numbers.length; i++) {
            NaturalNumber n = new NaturalNumber2(numbers[i]);
            NaturalNumber tooHigh = new NaturalNumber2(n);
            tooHigh.increment();
            NaturalNumber lowEnough = new NaturalNumber2(0);
            NaturalNumber r = new NaturalNumber2(results[i]);
            root(n, roots[i], tooHigh, lowEnough);
            if (n.equals(r)) {
                out.println("Test " + (i + 1) + " passed: root(" + numbers[i]
                        + ", " + roots[i] + ") = " + results[i]);
            } else {
                out.println("*** Test " + (i + 1) + " failed: root("
                        + numbers[i] + ", " + roots[i] + ") expected <"
                        + results[i] + "> but was <" + n + ">");
            }
        }

        out.close();
    }

}