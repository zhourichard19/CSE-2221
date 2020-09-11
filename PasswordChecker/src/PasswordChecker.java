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
public final class PasswordChecker {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PasswordChecker() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {

        if (s.length() < 7) {
            out.println("Password is too short");
        } else {

            int isUpper = containsUpperCaseLetter(s);
            int isLower = containsLowerCaseLetter(s);
            int isDigit = containsDigit(s);

            if (isUpper + isLower + isDigit > 2) {
                out.println("This password fulfills the requirments");
            } else if (isUpper == 0) {
                out.println("you are missing an uppercase letter");
            } else if (isLower == 0) {
                out.println("you are missing an lowercase letter");
            } else if (isDigit == 0) {
                out.println("you are missing a digit");
            }

        }
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static int containsUpperCaseLetter(String s) {
        int isUpper = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (Character.isUpperCase(letter) == true) {
                isUpper++;
            }
        }
        return isUpper;
    }

    /**
     * Checks if the given String contains an upper case letter.
     * 
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static int containsLowerCaseLetter(String s) {
        int isLower = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (Character.isLowerCase(letter) == true) {
                isLower++;
            }
        }
        return isLower;
    }

    /**
     * Checks if the given String contains an upper case letter.
     * 
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static int containsDigit(String s) {
        int isDigit = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (Character.isDigit(letter) == true) {
                isDigit++;
            }
        }
        return isDigit;
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

        out.println("Please enter a password for me to check");
        String password = in.nextLine();
        checkPassword(password, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
