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
public final class FactorialsNaturalNumbers {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private FactorialsNaturalNumbers() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void factorial(NaturalNumber x) {

        NaturalNumber one = new NaturalNumber2(1);

        if (x.compareTo(one) != 0) {
            NaturalNumber fact = new NaturalNumber2();
            fact.decrement();
            factorial(fact);
            x.multiply(fact);

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
         * Put your main program code here; it may call myMethod as shown
         */

        out.println("Enter the number you would like to take a factorial of:");
        NaturalNumber input = new NaturalNumber2(in.nextInteger());
        out.print(input + "! is equal to: ");
        factorial(input);
        out.print(input);

        in.close();
        out.close();
    }

}
