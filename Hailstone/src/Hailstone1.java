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
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        while (n > 1) {
            out.print(n + ", ");
            if (n % 2 == 0) {
                n = n / 2;

            } else {
                n = 3 * n + 1;
            }
        }
        out.print("1");
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
        
        int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
        
        int i = 1;
        while (i < 10) {
            a[i] = a[i - 1];
            i++;
        }
        
        out.print(a);
        
        in.close();
        out.close();
    }

}
