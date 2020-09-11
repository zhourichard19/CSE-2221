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
public final class ABCDGuesser2 {

    private ABCDGuesser2() {
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
     * Calculates the number that is gotten after multiplying everything
     * together
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a product of all the input numbers
     */
    private static double getProduct(double a, double b, double c, double d,
            double w, double x, double y, double z) {
        //multiplies all of the numbers after they are raised to a certain power
        double product = Math.pow(w, a) * Math.pow(x, b) * Math.pow(y, c)
                * Math.pow(z, d);
        return product;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //initializes the original variables
        double estimate = 0.0;
        final double minError = 30.0;

        //runs the method to get the constant from the user
        double constant = getPositiveDouble(in, out);

        out.println(
                "I will now be asking you to give me four numbers that are positive and not equal to one.");

        //runs the method to get the users four number used for estimated
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        //initializes the array used for the estimation
        final double[] arr = new double[] { -5, -4, -3, -2, -1, -1.0 / 2.0,
                -1.0 / 3.0, -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1,
                2, 3, 4, 5 };

        //initializes the variables used in the estimation
        double product = 0.0;
        double expa = 0.0;
        double expb = 0.0;
        double expc = 0.0;
        double expd = 0.0;

        //nested loops that go through every combination of exponents and multiplication in the array
        for (int i = 0; i < arr.length; i++) {
            double a = arr[i];
            for (int j = 0; j < arr.length; j++) {
                double b = arr[j];
                for (int k = 0; k < arr.length; k++) {
                    double c = arr[k];
                    for (int l = 0; l < arr.length; l++) {
                        double d = arr[l];
                        product = getProduct(a, b, c, d, w, x, y, z);
                        l++;

                        //calculates the difference betwee nthe number and the constant
                        double sub = (product - constant);

                        //makes the difference positive if the number is smaller than the constant
                        if (sub < 0) {
                            sub = sub * -1.0;
                        }

                        //assigns all of the values to the lowest if it is the lowest
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

        //prints out the result
        out.println("The number is " + estimate);
        out.println("The exponents are " + expa + ", " + expb + ", " + expc
                + ", " + expd);

        //calculates the percent error that the user had
        double percentError = (product - constant) / constant * 100.0;

        out.println("The percent error is " + percentError + "%");
    }
}
