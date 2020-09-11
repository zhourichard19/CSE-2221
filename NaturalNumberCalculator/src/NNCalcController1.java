import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Richard Zhou
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        //sets the bottom and top to natural numbers
        NaturalNumber input = model.bottom();
        NaturalNumber output = model.top();

        //updates the displays on bottom and top with the natural numbers
        view.updateBottomDisplay(input);
        view.updateTopDisplay(output);

        boolean allowed = true;
        //Checks to see if division is allowed to be used in the situation
        //makes sure that the bottom number is  bigger than an empty value
        if (input.compareTo(new NaturalNumber2()) > 0) {
            //updates the boolean and sets it to the boolean for updateDivide
            allowed = true;
            view.updateDivideAllowed(allowed);
        } else {
            //if it is not then the boolean is set to false
            allowed = false;
            view.updateDivideAllowed(allowed);
        }
        //Checks to see if subtraction is allowed to be used in the situation
        //checks to make sure that the bottom is smaller than the top
        if (input.compareTo(model.top()) < 0) {
            //if the bottom is smaller than the top, then the boolean is set to
            //true
            allowed = true;
            //updates the boolean to the respectful boolean
            view.updateSubtractAllowed(allowed);
        } else {
            allowed = false;
            //updates the boolean to the respectful boolean
            view.updateSubtractAllowed(allowed);
        }
        //Checks to see if power is allowed to be used in the situation
        //checks to make sure the bottom number does not exceed the integer max
        if (input.compareTo(INT_LIMIT) <= 0) {
            //if the bottom is lower than the max integer then it is true
            allowed = true;
            //updates the boolean to the respectful boolean
            view.updatePowerAllowed(allowed);
        } else {
            //if not is false
            allowed = false;
            //updates the boolean to the respectful boolean
            view.updatePowerAllowed(allowed);
        }
        //Checks to see if root is allowed to be used in the situation
        //checks to see if the root is greater than two and the bottom number
        //is also smaller than the max integer value
        if (input.compareTo(TWO) >= 0 && input.compareTo(INT_LIMIT) <= 0) {
            //checks if the root is less than two because cant take a root with
            //one or zero
            //if this is true then the boolean is true
            allowed = true;
            //updates the boolean to the respectful boolean
            view.updateRootAllowed(allowed);
        } else {
            allowed = false;
            //updates the boolean to the respectful boolean
            view.updateRootAllowed(allowed);
        }

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        //reupdates the model and view values
        this.model = model;
        this.view = view;
        //goes inot hte update method and updates the method
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //sets the top value to the bottom value
        top.copyFrom(bottom);

        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //adds the bottom to the top and then transfers that value to the top
        //clearing the bottom value
        top.add(bottom);
        bottom.transferFrom(top);

        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //subtracts the bottom to the top and then transfers that value to the top
        //clearing the bottom value
        top.subtract(bottom);
        bottom.transferFrom(top);

        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //multiplies the bottom to the top and then transfers that value to the top
        //clearing the bottom value
        top.multiply(bottom);
        bottom.transferFrom(top);
        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //divides the number by the bottom and set the remainder to r
        NaturalNumber r = top.divide(bottom);
        //sets the bottom to the division
        bottom.transferFrom(top);
        //sets the top to the remainder
        top.transferFrom(r);

        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //sets the bottom number to an int
        int lower = bottom.toInt();
        //raises the top number to the power of the int
        top.power(lower);
        //sets the bottom to the top number
        bottom.transferFrom(top);

        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        //saves the top and bottom values into natural numbers
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //sets the bottom number to an int
        int lower = bottom.toInt();
        //takes the nth root of the top depending on the bottom
        top.root(lower);
        //transfers the bottom number from the top
        bottom.transferFrom(top);

        //updates the view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        /*
         * Get aliases to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.multiplyBy10(digit);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

}
