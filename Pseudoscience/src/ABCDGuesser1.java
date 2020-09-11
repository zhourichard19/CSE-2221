import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 *
 */

/**
 * @author 15202
 *
 */
public final class ABCDGuesser1 {

    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

        //sets the double to greater than zero so the while loop would run smoothly
        double constant = -1.0;
        //the loop runs while the user number is below zero and this would keep on running until the number is positive
        while (constant < 0) {
            out.println(
                    "Give me a positive and real constant to be estimated.");
            String usr = in.nextLine();
            if (FormatChecker.canParseDouble(usr)) {
                constant = Double.parseDouble(usr);
            }
        }

        return constant;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        //sets the double to greater than zero so the while loop would run smoothly
        double num = -1.0;
        //the loop runs while the user number is below zero and this would keep
        //on running until the number is positive and not one
        while ((num < 0) || (num == 1)) {
            out.println("Give me one of your favorite numbers");
            String usr = in.nextLine();
            if (FormatChecker.canParseDouble(usr)) {
                num = Integer.parseInt(usr);
            }
        }

        return num;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //initializes the variables needed
        double estimate = 0.0;
        final double minError = 30.0;

        //runs the method to get a constant from the user
        double constant = getPositiveDouble(in, out);

        out.println(
                "I will now be asking you to give me four numbers that are positive and not equal to one.");

        //gets the four random number by running another method
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        //sets the array for the different types of exponents
        final double[] arr = new double[] { -5, -4, -3, -2, -1, -1.0 / 2.0,
                -1.0 / 3.0, -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1,
                2, 3, 4, 5 };

        //initialize variables for the while loops
        double product = 0.0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;

        //initializes variables for final answer
        double expa = 0.0;
        double expb = 0.0;
        double expc = 0.0;
        double expd = 0.0;

        // nested loops that run through every exponent in the array for each number and multiplies all of them together
        while (i < arr.length) {
            double a = arr[i];
            i++;
            j = 0;
            while (j < arr.length) {
                double b = arr[j];
                j++;
                k = 0;
                while (k < arr.length) {
                    double c = arr[k];
                    k++;
                    l = 0;
                    while (l < arr.length) {
                        double d = arr[l];
                        //multiplies all of the variables
                        product = Math.pow(w, a) * Math.pow(x, b)
                                * Math.pow(y, c) * Math.pow(z, d);
                        l++;

                        //subtraction to see which number is closest
                        double sub = (product - constant);

                        //makes the difference positive if the number is below the constant
                        if (sub < 0) {
                            sub = sub * -1.0;
                        }

                        //checks to see if the lower difference number is there and if it is, then it will be saved with the exponents used
                        if (sub < minError) {
                            estimate = product;
                            expa = a;
                            expb = b;
                            expc = c;
                            expd = d;
                        }
                    }
                }
            }
        }

        out.println("The number is " + estimate);
        out.println("The exponents are " + expa + ", " + expb + ", " + expc
                + ", " + expd);

        //calculates the percent error of the estimated number
        double percentError = (product - constant) / constant * 100.0;

        out.println("The percent error is " + percentError + "%");
    }
}
