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
public final class CoingChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    int dollarCount = 0;
    int halfCount = 0;
    int quarter = 0;
    int dime = 0;
    int nickel = 0;
    int penny = 0;

    out.println("give me a number to calculate the amount of change it is");
    int money = in.nextInteger();

    dollarCount=money/100;money=money%100;

    halfCount=money/50;money=money%50;

    quarter=money/25;money=money%25;

    dime=money/10;money=money%10;

    nickel=money/5;money=money%5;

    penny=money;

    out.println("The change for you will be "+dollarCount+" dollars "+halfCount+" half Dollars "+quarter+" quarters "+dime+" dimes "+nickel+" nickels "+penny+" pennies ");
    /*
     * Close input and output streams
     */
    in.close();out.close();
}

    private CoingChange2() {
    }

    private static int coinCountsToMakeChange(int money, int[] coinVal) {

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

        out.println("give me a number to calculate the amount of change it is");
        int money = in.nextInteger();

        int coinAmt = coinCountsToMakeChange (money, coinVal);

        out.println("The change for you will be " + coinAmt[0] + " dollars "
                + coinAmt[1] + " half Dollars " + coinAmt[2] + " quarters " + coinAmt[3]
                + " dimes " + coinAmt[4] + " nickels " + coinAmt[] + " pennies ");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
