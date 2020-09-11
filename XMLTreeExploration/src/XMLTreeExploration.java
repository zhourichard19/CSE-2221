import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int middleNum = xt.numberOfChildren() / 2;
        XMLTree middleChild = xt.child(middleNum - 1);

        if (middleChild.isTag()) {
            out.println("the middle child is a tag");
            int numChild = middleChild.numberOfChildren();
            out.println("the number of children in this tag is" + numChild);
        } else {
            out.println("the middle child is a text");
        }
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

        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");

        //xml.display();

        if (xml.isTag()) {
            String label = xml.label();
            out.println("The root is a tag and the label is " + label);
        } else {
            String label = xml.label();
            out.println("The root is a tag and the label is " + label);
        }

        XMLTree result = xml.child(0);
        XMLTree channel = result.child(0);

        int chanChild = channel.numberOfChildren();

        out.println("The number of children in channel is " + chanChild);

        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);

        String titleLabel = titleText.label();
        out.println("The title of the this next root is " + titleLabel);

        XMLTree astronomy = channel.child(10);

        if (astronomy.hasAttribute("sunset")) {
            out.print("The attribute is sunset");
        } else if (astronomy.hasAttribute("midday")) {
            out.println("The attribute is midday");
        }

        printMiddleNode(channel, out);

        in.close();
        out.close();
    }

}
