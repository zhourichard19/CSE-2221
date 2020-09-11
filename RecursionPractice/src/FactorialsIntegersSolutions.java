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
public final class FactorialsIntegersSolutions {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private FactorialsIntegersSolutions() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static int factorial(int x) {

        if (x != 1) { // if x = 1, 1! = 1, otherwise multiply
            x = factorial(x - 1) * x;
        }
        return x;
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
        int input = in.nextInteger();
        out.print(input + "! is equal to: " + factorial(input));

        in.close();
        out.close();
    }

}
