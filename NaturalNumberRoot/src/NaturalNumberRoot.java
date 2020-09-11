import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program with implementation of {@code NaturalNumber} secondary operation
 * {@code root} implemented as static method.
 *
 * @author Richard Zhou
 *
 */
public final class NaturalNumberRoot {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NaturalNumberRoot() {
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
    public static void root(NaturalNumber n, int r) {
        assert n != null : "Violation of: n is  not null";
        assert r >= 2 : "Violation of: r >= 2";

        //Initializes the natural numbers used in the following code segment
        //One is the number for one
        NaturalNumber one = new NaturalNumber2(1);
        //initializes the NaturalNumbert for 2
        NaturalNumber two = new NaturalNumber2(2);
        //creates a maximum natural number
        NaturalNumber high = new NaturalNumber2(n);
        //creates a minimum for the natural number
        NaturalNumber low = new NaturalNumber2(0);
        //creates a guess variable
        NaturalNumber guess = new NaturalNumber2(0);
        //creates a variable to find the difference between two numbers
        NaturalNumber diff = new NaturalNumber2(2);
        //creates a variable to check if the power of the nubmer is correct
        NaturalNumber pow = new NaturalNumber2(0);

        //increments high to get the maximum
        high.increment();

        //while loop to make sure that the guess is within 1 of each other and
        //stops the loop when the guess is reached
        while (diff.compareTo(one) > 0) {

            //Copy's guess from the high and then adds the lowest, then divides
            //guess by two resulting in the middle
            guess.copyFrom(high);
            guess.add(low);
            guess.divide(two);

            //makes a power for guess and takes guess to the power of r
            pow.copyFrom(guess);
            pow.power(r);

            //checks to see if the guess is greater than or less than the natural number
            if (n.compareTo(pow) < 0) {
                //makes guess the max if it is above the actual root
                high.copyFrom(guess);
            } else {
                //makes guess the max if it is above the actual root
                low.copyFrom(guess);
            }
            //resets the difference to be the high minus the low. This would find
            //the new in between
            diff.copyFrom(high);
            diff.subtract(low);
        }
        //saves the lowest value to low after the while loop and if statement are
        //run thru
        n.copyFrom(low);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        //Initializes the string with different values to take the square root of
        final String[] numbers = { "0", "1", "13", "1024", "189943527", "0",
                "1", "13", "4096", "189943527", "0", "1", "13", "1024",
                "189943527", "82", "82", "82", "82", "82", "9", "27", "81",
                "243", "143489073", "2147483647", "2147483648",
                "9223372036854775807", "9223372036854775808",
                "618970019642690137449562111",
                "162259276829213363391578010288127",
                "170141183460469231731687303715884105727" };
        //Initializes roots that are taken to the power of
        final int[] roots = { 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 15, 15, 15, 15, 15,
                2, 3, 4, 5, 15, 2, 3, 4, 5, 15, 2, 2, 3, 3, 4, 5, 6 };
        //Initializes the results that should be returned from the method
        final String[] results = { "0", "1", "3", "32", "13782", "0", "1", "2",
                "16", "574", "0", "1", "1", "1", "3", "9", "4", "3", "2", "1",
                "3", "3", "3", "3", "3", "46340", "46340", "2097151", "2097152",
                "4987896", "2767208", "2353973" };

        for (int i = 0; i < numbers.length; i++) {
            //initializes the new natural numbers used in the method
            NaturalNumber n = new NaturalNumber2(numbers[i]);
            NaturalNumber r = new NaturalNumber2(results[i]);
            //calls the root method which would take the root of the given array number
            root(n, roots[i]);
            //Checks to see if the root gets the correct number value and if
            //the value is correct, then it prints out a certain statement, otherwise
            //if false, it will print out a different response
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