import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Richard Zhou
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        //creates natural numbers used in code below
        NaturalNumber value = new NaturalNumber2(0);
        NaturalNumber leftVal = new NaturalNumber2(0);
        NaturalNumber rightVal = new NaturalNumber2(0);

        //checks if there are any children in the root otherwise returning the final value
        if (exp.numberOfChildren() == 0) {
            //sets value to the final label in the number
            value = new NaturalNumber2(exp.attributeValue("value"));
        } else {
            //Evaluates the left side of the tree recursivley by calling this method
            //over and over again until there is one number left
            //this would be set to the left side
            leftVal = evaluate(exp.child(0));
            //Evaluates the right side of the tree recursivley by calling this method
            //over and over again until there is one number left
            //this would be set to the left side
            rightVal = evaluate(exp.child(1));

            //checks to see if the label is plus. If the label is plus then it
            //does addition
            if (exp.label().equals("plus")) {
                //copies the value so the two variables do not point at the same value
                value.copyFrom(leftVal);
                //value is then copied to right
                value.add(rightVal);
            }
            //checks to see if the label is minus. If the label is plus then it
            //does subtraction
            else if (exp.label().equals("minus")) {
                //checks to make sure the number does not return negative,
                //other wise natural number
                //will not work.
                if (rightVal.compareTo(leftVal) > 0) {
                    //command for error is thrown if there is an error ie. negative number
                    Reporter.fatalErrorToConsole(
                            "Violate pre condition for subtract command");
                } else {
                    //copys the value so the two variables do not point at the same value
                    value.copyFrom(leftVal);
                    //value is then subtracted from the right value
                    value.subtract(rightVal);
                }
            }
            //checks to see if the label is times. If the label is plus then it does times
            else if (exp.label().equals("times")) {
                //copies the value so the two variables do not point at the same value
                value.copyFrom(leftVal);
                //value is then multiplied from the right value
                value.multiply(rightVal);
            }
            //checks to see if the label is divide. If the label is plus then
            //it does division
            else if (exp.label().equals("divide")) {
                if (rightVal.isZero()) {
                    //checks to make sure the number does not return a number
                    //divided by zero
                    //because in math that is not possible
                    Reporter.fatalErrorToConsole(
                            "Cannot divide by zero in math");
                } else {
                    //copies the value so the two variables do not point at the same value
                    value.copyFrom(leftVal);
                    //value is then divided by the right value
                    value.divide(rightVal);
                }
            }

        }

        return value;
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

        //asks for the name of the file
        out.print("Enter the name of an expression XML file: ");
        //prints the file unto the string "file"
        String file = in.nextLine();
        //checks while the file is not empty
        while (!file.equals("")) {
            //makes a new tree from the file
            XMLTree exp = new XMLTree1(file);
            //evaluates the tree by calling the recursive method evaluate
            out.println(evaluate(exp.child(0)));
            //asks for the name of the file until stopped
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}