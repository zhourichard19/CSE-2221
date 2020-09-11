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
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {

        //initializes the new variable
        double r = x;
        //checks to make sure that the x value is not zero so then the program will run
        if (x != 0) {
            //when the x value is not zero, the program will run the square root until it is confirmed
            while (((r * r) - x) / x > 0.0001) {
                r = (r + x / r) / 2;
            }
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

        String answer = "y";

        //sets the answer to y so that when the condition is changed, the loop is done
        while (answer == "y") {
            //prompts user to print if they want to do a square root
            out.println("Do you want to print another square root?(y/n)");
            answer = in.nextLine();

            if (answer.equals("y")) {

                //asks the user to input a number to take the square root of
                out.println("give a number to take a square root of");
                double number = Double.parseDouble(in.nextLine());

                //runs the next program with the new values
                double rootNum = sqrt(number);

                out.println("The square root is about " + rootNum);
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}