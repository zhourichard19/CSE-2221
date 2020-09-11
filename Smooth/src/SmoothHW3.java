import components.sequence.Sequence;

/**
 * Implements method to smooth a {@code Sequence<Integer>}.
 *
 * @author Richard Zhou
 *
 */
public final class SmoothHW3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private SmoothHW3() {
    }

    /**
     * Smooths a given {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     * @param s2
     *            the resulting sequence
     * @replaces s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     * </pre>
     */
    public static Sequence<Integer> smooth2(Sequence<Integer> s1) {
        assert s1 != null : "Violation of: s1 is not null";
        assert s1.length() >= 1 : "Violation of: |s1| >= 1";

        //without recursion
        Sequence<Integer> s2 = s1.newInstance();
        for (int i = 0; i < s1.length(); i++) {
            int firstNum = s1.remove(0);
            int secondNum = s1.remove(0);
            s1.add(0, secondNum);
            s1.add(s1.length() - 1, firstNum);
            if (s2.length() < s1.length() - 1) {
                s2.add(i, (firstNum + secondNum) / 2);
            }
        }

        return s2;

    }

    //Using Recursion
    public static Sequence<Integer> smooth3(Sequence<Integer> s1) {
        assert s1 != null : "Violation of: s1 is not null";
        assert s1.length() >= 1 : "Violation of: |s1| >= 1";

        Sequence<Integer> s2 = s1.newInstance();
        if (s1.length() > 1) {
            int firstNum = s1.remove(0);
            int secondNum = s1.remove(0);
            s1.add(0, secondNum);
            s2.transferFrom(smooth3(s1));
            s2.add(0, (firstNum + secondNum) / 2);
            s1.add(0, firstNum);
        }
        return s2;

    }
}