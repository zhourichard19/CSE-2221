import components.naturalnumber.NaturalNumber;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test {@code NaturalNumberInstanceOps} methods subtract and power.
 *
 * @author Paolo Bucci
 *
 */
public final class NaturalNumberTest {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NaturalNumberTest() {
    }

    /**
     * Get command from user.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return the command entered by the user
     * @updates in.content
     * @updates out.content
     * @requires in.is_open and out.is_open
     * @ensures <pre>
     * [displays a menu of available commands, prompts the user to
     *   enter a command, inputs and returns the command]
     * </pre>
     */
    private static String getCommand(SimpleReader in, SimpleWriter out) {
        out.println();
        out.println("Command: s [subtract]");
        out.println("         p [power]");
        out.print("         q [quit]: ");
        return in.nextLine();
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

        String command = getCommand(in, out);
        while (!command.equals("q")) {
            out.println();
            if (command.equals("s")) {
                out.print("Enter first natural number: ");
                NaturalNumber n1 = new NaturalNumberInstanceOps(in.nextLine());
                out.print("Enter second natural number: ");
                NaturalNumber n2 = new NaturalNumberInstanceOps(in.nextLine());
                out.println("Before subtract: n1 = " + n1 + ", n2 = " + n2);
                n1.subtract(n2);
                out.println("After subtract:  n1 = " + n1 + ", n2 = " + n2);
            } else if (command.equals("p")) {
                out.print("Enter a natural number: ");
                NaturalNumber n = new NaturalNumberInstanceOps(in.nextLine());
                out.print("Enter a non-negative integer: ");
                int p = in.nextInteger();
                out.println("Before power: n = " + n);
                n.power(p);
                out.println("After power:  n = " + n);
            } else {
                out.println(command);
            }
            command = getCommand(in, out);
        }

        in.close();
        out.close();
    }

}