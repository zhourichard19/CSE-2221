import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Richard Zhou
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        //initializes the variables needed for the code
        int value = 0;
        int leftVal = 0;
        int rightVal = 0;

        //checks to see if the code has children, if not the code will get the final value
        if (exp.numberOfChildren() == 0) {
            //sets value to the value of the final attribute
            value = Integer.parseInt(exp.attributeValue("value"));
        } else {
            //evaluates the left side of the tree recursivley by running the method
            //until the left is finished evaluated.
            leftVal = evaluate(exp.child(0));
            //evaluates the left side of the tree recursivley by running the method
            //until the left is finished evaluated.
            rightVal = evaluate(exp.child(1));

            //if label is plus then the code uses the addition method to add the code
            //from left to right
            if (exp.label().equals("plus")) {
                value = leftVal + rightVal;
            }
            //if label is plus then the code uses the subtract method to add the code
            //from left to right
            else if (exp.label().equals("minus")) {
                value = leftVal - rightVal;
            }
            //if label is plus then the code uses the time method to add the code
            //from left to right
            else if (exp.label().equals("times")) {
                value = leftVal * rightVal;
            }
            //if label is plus then the code uses the divide method to add the code
            //from left to right
            else if (exp.label().equals("divide")) {
                value = leftVal / rightVal;
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