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
public final class CoingChange3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoingChange3() {
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

        int [] coinVal = {100,50,25,10,5,1};
        int [] coinAmt = {0,0,0,0,0,0};
        
        out.println("give me a number to calculate the amount of change it is");
        int money = in.nextInteger();
        
        for (int i = 0; i< coinVal.length ; i++)
        {
            coinAmt[i] = money / coinVal[i];
            money = money % coinVal[i];
        }

        out.println("The change for you will be " + coinAmt[0] + " dollars "
                + coinAmt[1] + " half Dollars " + coinAmt[2] + " quarters " + coinAmt[3]
                + " dimes " + coinAmt[4] + " nickels " + coinAmt[5] + " pennies ");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
