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
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        //Makes r the number that x was
        double r = x;
        //makes a loop that runs and upadtes r everytime that r gets changed until r is greater than the percent error
        while (((r * r) - x) / x > 0.0001) {
            r = (r + x / r) / 2;
        }
        return r;

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

        //prompts for whether or not the user wants to take the square root
        out.println("Do you want to print another square root?(y/n)");
        String answer = in.nextLine();

        //while the answer is yes, the program will ask for a number to take a square root
        //and then will return the estimated square root of that number
        if (answer.equals("y")) {

            out.println("give a number to take a square root of");
            double number = Double.parseDouble(in.nextLine());

            double rootNum = sqrt(number);

            out.println("The square root is about " + rootNum);
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
