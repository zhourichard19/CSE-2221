import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class RevIncDecSolutions {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RevIncDecSolutions() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static String revString(String s) {

        String subString = s.substring(1);
        String string = s;
        if (s.length() > 1) {
            string = revString(subString) + s.charAt(0);
        }

        return string;
    }

    private static void increment(NaturalNumber x) {

        int lastDigit = x.divideBy10();
        lastDigit++;

        if (lastDigit == 10) {
            lastDigit = 0;
            increment(x);
        }

        x.multiplyBy10(lastDigit);
    }

    private static void decrement(NaturalNumber x) {
        int lastDigit = x.divideBy10();
        lastDigit--;

        if (lastDigit < 0) {
            lastDigit = 9;
            decrement(x);
        }

        x.multiplyBy10(lastDigit);
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
         * Put your main program code here; it may call myMethod as shown
         */

        out.println("Please enter a string to reverse: ");
        String abc = in.nextLine();
        String revABC = revString(abc);
        out.println(revABC);

        out.println("Please enter a number to increment");
        NaturalNumber x = new NaturalNumber2(in.nextInteger());
        out.print("Before: x = " + x + " After: x = ");
        increment(x);
        out.print(x);

        out.println("\nPlease enter a number to decrement");
        NaturalNumber y = new NaturalNumber2(in.nextInteger());
        out.print("Before: y = " + y + " After: y = ");
        decrement(y);
        out.print(y);

        in.close();
        out.close();
    }

}
