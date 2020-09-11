import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Model class.
 *
 * @author Richard Zhou
 */
public final class NNCalcModel1 implements NNCalcModel {

    /**
     * Model variables.
     */
    private final NaturalNumber top, bottom;

    /**
     * Default constructor.
     */
    public NNCalcModel1() {
        //initializes the names for the top and bottoms screens for calculator
        this.top = new NaturalNumber2();
        this.bottom = new NaturalNumber2();
    }

    @Override
    public NaturalNumber top() {

        //gets the top screen value
        return this.top;
    }

    @Override
    public NaturalNumber bottom() {

        //gets the bottom screen value
        return this.bottom;
    }

}
