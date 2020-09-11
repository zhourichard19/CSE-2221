import java.util.Arrays;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ParameterPassing {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ParameterPassing() {
    }

    /**
     * Test parameter passing for primitive type.
     *
     * @param i
     *            the parameter of primitive type int
     */
    private static void test1(int i) {
        i = i + 1;
    }

    /**
     * Test parameter passing for (immutable) reference type.
     *
     * @param s
     *            the parameter of reference type String
     */
    private static void test2(String s) {
        s.toUpperCase();
    }

    /**
     * Test parameter passing for (mutable) reference type.
     *
     * @param n
     *            the parameter of reference type NaturalNumber
     */
    private static void test3(NaturalNumber n) {
        n.increment();
    }

    /**
     * Test parameter passing for (immutable) reference type.
     *
     * @param s
     *            the parameter of reference type String
     */
    private static void test4(String s) {
        s = s.toUpperCase();
    }

    /**
     * Test parameter passing for (immutable) reference type.
     *
     * @param s
     *            the parameter of reference type String
     */
    private static void test5(String s) {
        s = s + ", world!";
    }

    /**
     * Test parameter passing for (mutable) reference type.
     *
     * @param n
     *            the parameter of reference type NaturalNumber
     */
    private static void test6(NaturalNumber n) {
        n = new NaturalNumber2(n.toString() + "1");
    }

    /**
     * Test parameter passing for array type.
     *
     * @param a
     *            the parameter of array type
     */
    private static void test7(int[] a) {
        a[0] = a[0] + 1;
    }

    /**
     * Test swapping for primitive type.
     *
     * @param i
     *            the first parameter of primitive type int
     * @param j
     *            the second parameter of primitive type int
     */
    private static void swap1(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }

    /**
     * Test swapping for (immutable) reference type.
     *
     * @param s1
     *            the first parameter of reference type String
     * @param s2
     *            the second parameter of reference type String
     */
    private static void swap2(String s1, String s2) {
        String tmp = s1;
        s1 = s2;
        s2 = tmp;
    }

    /**
     * Test swapping for (mutable) reference type.
     *
     * @param n1
     *            the first parameter of reference type NaturalNumber
     * @param n2
     *            the second parameter of reference type NaturalNumber
     */
    private static void swap3(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber tmp = n1;
        n1 = n2;
        n2 = tmp;
    }

    /**
     * Test swapping for array type.
     *
     * @param a1
     *            the first parameter of array type
     * @param a2
     *            the second parameter of array type
     */
    private static void swap4(int[] a1, int[] a2) {
        int[] tmp = a1;
        a1 = a2;
        a2 = tmp;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        out.println("test1:");
        int x = 7;
        out.println("  Before: x = " + x);
        test1(x);
        out.println("  After:  x = " + x);
        out.println();

        out.println("test2:");
        String str1 = "hello";
        out.println("  Before: str1 = " + str1);
        test2(str1);
        out.println("  After:  str1 = " + str1);
        out.println();

        out.println("test3:");
        NaturalNumber num1 = new NaturalNumber2("17");
        out.println("  Before: num1 = " + num1);
        test3(num1);
        out.println("  After:  num1 = " + num1);
        out.println();

        out.println("test4:");
        String str2 = "hello";
        out.println("  Before: str2 = " + str2);
        test4(str2);
        out.println("  After:  str2 = " + str2);
        out.println();

        out.println("test5:");
        String str3 = "Hello";
        out.println("  Before: str3 = " + str3);
        test5(str3);
        out.println("  After:  str3 = " + str3);
        out.println();

        out.println("test6:");
        NaturalNumber num2 = new NaturalNumber2("17");
        out.println("  Before: num2 = " + num2);
        test6(num2);
        out.println("  After:  num2 = " + num2);
        out.println();

        out.println("swap1:");
        int x1 = 5, x2 = 8;
        out.println("  Before: x1 = " + x1 + ", x2 = " + x2);
        swap1(x1, x2);
        out.println("  After:  x1 = " + x1 + ", x2 = " + x2);
        out.println();

        out.println("swap2:");
        str1 = "legends";
        str2 = "leaders";
        out.println("  Before: str1 = " + str1 + ", str2 = " + str2);
        swap2(str1, str2);
        out.println("  After:  str1 = " + str1 + ", str2 = " + str2);
        out.println();

        out.println("swap3:");
        num1 = new NaturalNumber2(43210);
        num2 = new NaturalNumber2(24601);
        out.println("  Before: num1 = " + num1 + ", num2 = " + num2);
        swap3(num1, num2);
        out.println("  After:  num1 = " + num1 + ", num2 = " + num2);
        out.println();

        out.println("test7:");
        int[] array = { 1, 2, 3 };
        out.println("  Before: array = " + Arrays.toString(array));
        test7(array);
        out.println("  After:  array = " + Arrays.toString(array));
        out.println();

        out.println("swap4:");
        int[] array1 = { 2, 2, 2, 1 };
        int[] array2 = { 10, 2, 2012 };
        out.println("  Before: array1 = " + Arrays.toString(array1)
                + ", array2 = " + Arrays.toString(array2));
        swap4(array1, array2);
        out.println("  After:  array1 = " + Arrays.toString(array1)
                + ", array2 = " + Arrays.toString(array2));
        out.println();

        out.close();
    }

}