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
public final class CoingChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoingChange1() {
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
        
    }

}
