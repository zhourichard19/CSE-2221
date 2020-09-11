import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Test class for NaturalNumber calculator GUI (view in MVC).
 *
 * @author Put your name here
 */
public final class NNCalcViewLab extends JFrame implements ActionListener {

    /**
     * Text areas.
     */
    private final JTextArea tTop, tBottom;

    /**
     * Operator and related buttons.
     */
    private final JButton bClear, bSwap, bEnter, bAdd, bSubtract, bMultiply,
            bDivide, bPower, bRoot;

    /**
     * Digit entry buttons.
     */
    private final JButton[] bDigits;

    /**
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 5, TEXT_AREA_WIDTH = 20,
            DIGIT_BUTTONS = 10, MAIN_BUTTON_PANEL_GRID_ROWS = 4,
            MAIN_BUTTON_PANEL_GRID_COLUMNS = 4, SIDE_BUTTON_PANEL_GRID_ROWS = 3,
            SIDE_BUTTON_PANEL_GRID_COLUMNS = 1, CALC_GRID_ROWS = 3,
            CALC_GRID_COLUMNS = 1;

    /**
     * Text areas.
     */
    private final JTextArea topText, bottomText;

    /**
     * Buttons for digits.
     */
    private final JButton[] digButton;

    /**
     * No-argument constructor.
     */
    public NNCalcViewLab() {

        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Natural Number Calculator");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Create widgets
         */

        this.topText = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.bottomText = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);

        this.bAdd = new JButton("+");
        this.bSubtract = new JButton("-");
        this.bMultiply = new JButton("*");
        this.bDivide = new JButton("/");
        this.bRoot = new JButton("root");
        this.bPower = new JButton("power");
        this.bClear = new JButton("clear");
        this.bSwap = new JButton("swap");
        this.bEnter = new JButton("enter");
        this.digButton = new JButton[DIGIT_BUTTONS];
        this.digButton[0] = new JButton("0");
        this.digButton[1] = new JButton("1");
        this.digButton[2] = new JButton("2");
        this.digButton[3] = new JButton("3");
        this.digButton[4] = new JButton("4");
        this.digButton[5] = new JButton("5");
        this.digButton[6] = new JButton("6");
        this.digButton[7] = new JButton("7");
        this.digButton[8] = new JButton("8");
        this.digButton[9] = new JButton("9");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */

        this.topText.setEditable(false);
        this.topText.setLineWrap(true);
        this.topText.setWrapStyleWord(true);
        this.bottomText.setEditable(false);
        this.bottomText.setLineWrap(true);
        this.bottomText.setWrapStyleWord(true);
        /*
         * Initially, the following buttons should be disabled: divide (divisor
         * must not be 0) and root (root must be at least 2) -- hint: see the
         * JButton method setEnabled
         */

        this.bDivide.setEnabled(false);
        this.bRoot.setEnabled(false);

        /*
         * Create scroll panes for the text areas in case number is long enough
         * to require scrolling
         */

        JScrollPane inputTextScrollPane = new JScrollPane(this.topText);
        JScrollPane outputTextScrollPane = new JScrollPane(this.bottomText);

        /*
         * Create main button panel
         */

        JPanel buttonPanel = new JPanel(new GridLayout(
                MAIN_BUTTON_PANEL_GRID_ROWS, MAIN_BUTTON_PANEL_GRID_COLUMNS));

        /*
         * Add the buttons to the main button panel, from left to right and top
         * to bottom
         */

        for (int i = 7; i < 10; i++) {
            buttonPanel.add(this.digButton[i]);
        }
        for (int i = 4; i < 7; i++) {
            buttonPanel.add(this.digButton[i]);
        }
        for (int i = 1; i < 3; i++) {
            buttonPanel.add(this.digButton[i]);
        }

        buttonPanel.add(this.bAdd);
        buttonPanel.add(this.bSubtract);
        buttonPanel.add(this.bMultiply);
        buttonPanel.add(this.bDivide);
        buttonPanel.add(this.digButton[0]);
        buttonPanel.add(this.bPower);
        buttonPanel.add(this.bRoot);
        /*
         * Create side button panel
         */
        JPanel sideButtonPanel = new JPanel(new GridLayout(
                MAIN_BUTTON_PANEL_GRID_ROWS, MAIN_BUTTON_PANEL_GRID_COLUMNS));

        sideButtonPanel.add(this.bSwap);
        sideButtonPanel.add(this.bEnter);
        sideButtonPanel.add(this.bClear);
        /*
         * Add the buttons to the side button panel, from left to right and top
         * to bottom/
         */

        /*
         * Create combined button panel organized using flow layout, which is
         * simple and does the right thing: sizes of nested panels are natural,
         * not necessarily equal as with grid layout
         */

        JPanel combinedPanel = new JPanel(new FlowLayout());

        /*
         * Add the other two button panels to the combined button panel
         */

        combinedPanel.add(buttonPanel);
        combinedPanel.add(sideButtonPanel);

        /*
         * Organize main window
         */

        this.setLayout(new GridLayout(CALC_GRID_ROWS, CALC_GRID_COLUMNS));

        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */

        this.add(inputTextScrollPane);
        this.add(outputTextScrollPane);

        // Set up the observers ----------------------------------------------

        /*
         * Register this object as the observer for all GUI events
         */

        this.bAdd.addActionListener(this);
        this.bSubtract.addActionListener(this);
        this.bMultiply.addActionListener(this);
        this.bDivide.addActionListener(this);
        this.bClear.addActionListener(this);
        this.bEnter.addActionListener(this);
        this.bSwap.addActionListener(this);
        this.bPower.addActionListener(this);

        for (int i = 0; i < 10; i++) {
            this.digButton[i].addActionListener(this);
        }

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(this,
                "You pressed: " + event.getActionCommand());
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        NNCalcViewLab view = new NNCalcViewLab();
    }

}