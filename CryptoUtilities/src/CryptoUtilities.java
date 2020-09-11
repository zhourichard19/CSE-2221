import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Utilities that could be used with RSA cryptosystems.
 *
 * @author Richard Zhou
 *
 */
public final class CryptoUtilities {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CryptoUtilities() {
    }

    /**
     * Useful constant, not a magic number: 3.
     */
    private static final int THREE = 3;

    /**
     * Pseudo-random number generator.
     */
    private static final Random GENERATOR = new Random1L();

    /**
     * Returns a random number uniformly distributed in the interval [0, n].
     *
     * @param n
     *            top end of interval
     * @return random number in interval
     * @requires n > 0
     * @ensures <pre>
     * randomNumber = [a random number uniformly distributed in [0, n]]
     * </pre>
     */
    public static NaturalNumber randomNumber(NaturalNumber n) {
        assert !n.isZero() : "Violation of: n > 0";
        final int base = 10;
        NaturalNumber result;
        int d = n.divideBy10();
        if (n.isZero()) {
            /*
             * Incoming n has only one digit and it is d, so generate a random
             * number uniformly distributed in [0, d]
             */
            int x = (int) ((d + 1) * GENERATOR.nextDouble());
            result = new NaturalNumber2(x);
            n.multiplyBy10(d);
        } else {
            /*
             * Incoming n has more than one digit, so generate a random number
             * (NaturalNumber) uniformly distributed in [0, n], and another
             * (int) uniformly distributed in [0, 9] (i.e., a random digit)
             */
            result = randomNumber(n);
            int lastDigit = (int) (base * GENERATOR.nextDouble());
            result.multiplyBy10(lastDigit);
            n.multiplyBy10(d);
            if (result.compareTo(n) > 0) {
                /*
                 * In this case, we need to try again because generated number
                 * is greater than n; the recursive call's argument is not
                 * "smaller" than the incoming value of n, but this recursive
                 * call has no more than a 90% chance of being made (and for
                 * large n, far less than that), so the probability of
                 * termination is 1
                 */
                result = randomNumber(n);
            }
        }
        return result;
    }

    /**
     * Finds the greatest common divisor of n and m.
     *
     * @param n
     *            one number
     * @param m
     *            the other number
     * @updates n
     * @clears m
     * @ensures n = [greatest common divisor of #n and #m]
     */
    public static void reduceToGCD(NaturalNumber n, NaturalNumber m) {

        /*
         * Use Euclid's algorithm; in pseudocode: if m = 0 then GCD(n, m) = n
         * else GCD(n, m) = GCD(m, n mod m)
         */

        //initializes the natural number that will be used in the method
        NaturalNumber k = new NaturalNumber2(0);

        //checks to see if m is zero and if m is, then the GCD has been found
        if (!m.isZero()) {
            //sets k to the remainder of n/m
            k = n.divide(m);
            //the remainder and sets that to m and sets m and sets that to n
            //When the code runs again, the loop will keep dividing until the m
            //is equal to zero which is going to be the remainder
            reduceToGCD(m, k);
            //copies n from m which is the Greatest common divisor
            n.copyFrom(m);
            //clears m
            m.clear();
        }

    }

    /**
     * Reports whether n is even.
     *
     * @param n
     *            the number to be checked
     * @return true iff n is even
     * @ensures isEven = (n mod 2 = 0)
     */
    public static boolean isEven(NaturalNumber n) {

        //sets all of the needed varianles in natural number needed for the code
        NaturalNumber k = new NaturalNumber2(0);
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber j = new NaturalNumber2();
        NaturalNumber zero = new NaturalNumber2(0);

        //copies the number in n to j
        j.copyFrom(n);
        //sets the remainder of j/2 to k
        k = j.divide(two);

        //if the remainder of any number divided by two is zero, then it is even
        //otherwise the number would be false
        return k.equals(zero);
    }

    /**
     * Updates n to its p-th power modulo m.
     *
     * @param n
     *            number to be raised to a power
     * @param p
     *            the power
     * @param m
     *            the modulus
     * @updates n
     * @requires m > 1
     * @ensures n = #n ^ (p) mod m
     */
    public static void powerMod(NaturalNumber n, NaturalNumber p,
            NaturalNumber m) {
        assert m.compareTo(new NaturalNumber2(1)) > 0 : "Violation of: m > 1";

        //sets the needed variables in the code for the code
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber power = new NaturalNumber2();
        NaturalNumber j = new NaturalNumber2();
        NaturalNumber copy = new NaturalNumber2(n);

        //checks if the exponent p is zero because anything to the zero
        //power is one
        if (p.isZero()) {
            //sets n to one because that is the power
            n.copyFrom(one);
            //checks to see if the power is greater than one
        } else if (p.compareTo(one) > 0) {
            //sets power to p which will be the exponent
            power.copyFrom(p);
            //divides the exponent by two because that is apart of the fast
            //powering algorithm
            power.divide(two);

            //raises the n value raised t the power recursively
            powerMod(n, power, m);

            //copies j from n
            j.copyFrom(n);
            //multiplies n by the j value which is itself before the power
            n.multiply(j);

            //checks to see if the power is odd. This would result in an extra
            //step
            if (!isEven(p)) {
                //multiplies n by itself before the powering of n which
                //changed the algorithm
                n.multiply(copy);
            }

        }

        //takes the modulo which sets the remainder of n/m to j
        j = n.divide(m);
        //copies that number back into n
        n.copyFrom(j);
    }

    /**
     * Reports whether w is a "witness" that n is composite, in the sense that
     * either it is a square root of 1 (mod n), or it fails to satisfy the
     * criterion for primality from Fermat's theorem.
     *
     * @param w
     *            witness candidate
     * @param n
     *            number being checked
     * @return true iff w is a "witness" that n is composite
     * @requires n > 2 and 1 < w < n - 1
     * @ensures <pre>
     * isWitnessToCompositeness =
     *     (w ^ 2 mod n = 1)  or  (w ^ (n-1) mod n /= 1)
     * </pre>
     */
    public static boolean isWitnessToCompositeness(NaturalNumber w,
            NaturalNumber n) {
        assert n.compareTo(new NaturalNumber2(2)) > 0 : "Violation of: n > 2";
        assert (new NaturalNumber2(1)).compareTo(w) < 0 : "Violation of: 1 < w";
        n.decrement();
        assert w.compareTo(n) < 0 : "Violation of: w < n - 1";
        n.increment();

        //sets all of the variables needed in the code
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber k = new NaturalNumber2(0);
        NaturalNumber j = new NaturalNumber2(0);
        NaturalNumber i = new NaturalNumber2(0);

        //puts copies of the parameters into the newly made variables so the
        //numbers can be changed without everything changing
        k.copyFrom(w);
        j.copyFrom(w);
        i.copyFrom(n);
        i.decrement();

        //calculates one of the rules to see if a number is composite by
        //squaring the k and then mod by n
        powerMod(k, two, n);
        //calculates one of the rules to see if a number is composite by
        //putting k to the power of n-1 and then mod by n
        powerMod(j, i, n);

        //checks to see if the numbers are composite
        //returns true if k is one and j is not
        //false otherwise
        return (k.equals(one)) || (!j.equals(one));

    }

    /**
     * Reports whether n is a prime; may be wrong with "low" probability.
     *
     * @param n
     *            number to be checked
     * @return true means n is very likely prime; false means n is definitely
     *         composite
     * @requires n > 1
     * @ensures <pre>
     * isPrime1 = [n is a prime number, with small probability of error
     *         if it is reported to be prime, and no chance of error if it is
     *         reported to be composite]
     * </pre>
     */
    public static boolean isPrime1(NaturalNumber n) {
        assert n.compareTo(new NaturalNumber2(1)) > 0 : "Violation of: n > 1";
        boolean isPrime;
        if (n.compareTo(new NaturalNumber2(THREE)) <= 0) {
            /*
             * 2 and 3 are primes
             */
            isPrime = true;
        } else if (isEven(n)) {
            /*
             * evens are composite
             */
            isPrime = false;
        } else {
            /*
             * odd n >= 5: simply check whether 2 is a witness that n is
             * composite (which works surprisingly well :-)
             */
            isPrime = !isWitnessToCompositeness(new NaturalNumber2(2), n);
        }
        return isPrime;
    }

    /**
     * Reports whether n is a prime; may be wrong with "low" probability.
     *
     * @param n
     *            number to be checked
     * @return true means n is very likely prime; false means n is definitely
     *         composite
     * @requires n > 1
     * @ensures <pre>
     * isPrime2 = [n is a prime number, with small probability of error
     *         if it is reported to be prime, and no chance of error if it is
     *         reported to be composite]
     * </pre>
     */
    public static boolean isPrime2(NaturalNumber n) {
        assert n.compareTo(new NaturalNumber2(1)) > 0 : "Violation of: n > 1";

        /*
         * Use the ability to generate random numbers (provided by the
         * randomNumber method above) to generate several witness candidates --
         * say, 10 to 50 candidates -- guessing that n is prime only if none of
         * these candidates is a witness to n being composite (based on fact #3
         * as described in the project description); use the code for isPrime1
         * as a guide for how to do this, and pay attention to the requires
         * clause of isWitnessToCompositeness
         */
        //sets the variables needed for the method
        //sets two to 2
        NaturalNumber two = new NaturalNumber2(2);
        //sets four to 4
        NaturalNumber four = new NaturalNumber2(4);
        //sets gen to an empty variable because it will be a random number later
        NaturalNumber gen = new NaturalNumber2();
        //creates a random number
        NaturalNumber random = new NaturalNumber2();

        //copies gen to be n and then subtracts four because the rule for prime
        //numbers must be checked with a number less than n-2
        //this will then be added bytwo to make up for the random number
        //generator starting at zero instead of 1
        gen.copyFrom(n);
        gen.subtract(four);

        //sets the amount of numbers the loop will go for
        int counts = 30;

        //sets a boolean variable to true
        boolean isPrime = true;
        //loops to check if a number is prime 30 times
        for (int i = 0; i < counts; i++) {

            //creates a random number and adds two to that number to make up
            //for the fact that the random number generator starts at zero
            random = randomNumber(gen);
            random.add(two);

            if (n.compareTo(new NaturalNumber2(THREE)) <= 0) {
                /*
                 * 2 and 3 are primes
                 */
                isPrime = true;
            } else if (isEven(n)) {
                /*
                 * evens are composite
                 */
                isPrime = false;
            } else {
                /*
                 * odd n >= 5: simply check whether 2 is a witness that n is
                 * composite (which works surprisingly well :-)
                 */
                //checks to see if the number is prime in comparison to a
                //random number
                isPrime = !isWitnessToCompositeness(random, n);
            }
        }
        //returns isPrime
        return isPrime;
    }

    /**
     * Generates a likely prime number at least as large as some given number.
     *
     * @param n
     *            minimum value of likely prime
     * @updates n
     * @requires n > 1
     * @ensures n >= #n and [n is very likely a prime number]
     */
    public static void generateNextLikelyPrime(NaturalNumber n) {
        assert n.compareTo(new NaturalNumber2(1)) > 0 : "Violation of: n > 1";

        /*
         * Use isPrime2 to check numbers, starting at n and increasing through
         * the odd numbers only (why?), until n is likely prime
         */

        //sets two to 2
        NaturalNumber two = new NaturalNumber2(2);

        //checks to see if the number is even and adds one to make it odd
        //even numbers are never prime
        if (isEven(n)) {
            n.increment();
        }
        //checks until the number is prime while it is odd. If the number is not
        //prime then the method adds two to the odd number
        while (!isPrime2(n)) {
            n.add(two);
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Sanity check of randomNumber method -- just so everyone can see how
         * it might be "tested"
         */
        final int testValue = 17;
        final int testSamples = 100000;
        NaturalNumber test = new NaturalNumber2(testValue);
        int[] count = new int[testValue + 1];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < testSamples; i++) {
            NaturalNumber rn = randomNumber(test);
            assert rn.compareTo(test) <= 0 : "Help!";
            count[rn.toInt()]++;
        }
        for (int i = 0; i < count.length; i++) {
            out.println("count[" + i + "] = " + count[i]);
        }
        out.println("  expected value = "
                + (double) testSamples / (double) (testValue + 1));

        /*
         * Check user-supplied numbers for primality, and if a number is not
         * prime, find the next likely prime after it
         */
        while (true) {
            out.print("n = ");
            NaturalNumber n = new NaturalNumber2(in.nextLine());
            if (n.compareTo(new NaturalNumber2(2)) < 0) {
                out.println("Bye!");
                break;
            } else {
                if (isPrime1(n)) {
                    out.println(n + " is probably a prime number"
                            + " according to isPrime1.");
                } else {
                    out.println(n + " is a composite number"
                            + " according to isPrime1.");
                }
                if (isPrime2(n)) {
                    out.println(n + " is probably a prime number"
                            + " according to isPrime2.");
                } else {
                    out.println(n + " is a composite number"
                            + " according to isPrime2.");
                    generateNextLikelyPrime(n);
                    out.println("  next likely prime is " + n);
                }
            }
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}