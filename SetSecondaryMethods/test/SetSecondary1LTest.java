import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

public final class SetSecondary1LTest {

    /**
     * Construct and return a {@code Set<String>} containing the given
     * {@code String}s.
     *
     * @param args
     *            the {@code String}s to put in the set
     * @return {@code Set<String>} of the given {@code String}s
     * @ensures createFromArgs = [the Set<String> of the given Strings]
     */
    private static Set<String> createFromArgs(String... args) {
        Set<String> set = new SetSecondary1L<String>();
        for (String s : args) {
            set.add(s);
        }
        return set;
    }

    @Test
    public void testAddEmptyEmpty() {
        Set<String> s1 = createFromArgs();
        Set<String> s1Expected = createFromArgs();
        Set<String> s2 = createFromArgs();
        Set<String> s2Expected = createFromArgs();
        s1.add(s2);
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
    }

    @Test
    public void testAddNonEmptyEmpty() {
        Set<String> s1 = createFromArgs("one");
        Set<String> s1Expected = createFromArgs("one");
        Set<String> s2 = createFromArgs();
        Set<String> s2Expected = createFromArgs();
        s1.add(s2);
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
    }

    @Test
    public void testAddEmptyNonEmpty() {
        Set<String> s1 = createFromArgs();
        Set<String> s1Expected = createFromArgs("one");
        Set<String> s2 = createFromArgs("one");
        Set<String> s2Expected = createFromArgs();
        s1.add(s2);
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
    }

    @Test
    public void testAddNonEmptyNonEmptyNonSubset() {
        Set<String> s1 = createFromArgs("one", "two");
        Set<String> s1Expected = createFromArgs("one", "two", "three");
        Set<String> s2 = createFromArgs("two", "three");
        Set<String> s2Expected = createFromArgs("two");
        s1.add(s2);
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
    }

    @Test
    public final void testRemoveEmptyEmpty() {
        Set<String> s1 = createFromArgs();
        Set<String> s1Expected = createFromArgs();
        Set<String> s2 = createFromArgs();
        Set<String> s2Expected = createFromArgs();
        Set<String> result = s1.remove(s2);
        Set<String> resultExpected = createFromArgs();
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
        assertEquals(resultExpected, result);
    }

    @Test
    public final void testRemoveNonEmptyEmpty() {
        Set<String> s1 = createFromArgs("one");
        Set<String> s1Expected = createFromArgs("one");
        Set<String> s2 = createFromArgs();
        Set<String> s2Expected = createFromArgs();
        Set<String> result = s1.remove(s2);
        Set<String> resultExpected = createFromArgs();
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
        assertEquals(resultExpected, result);
    }

    @Test
    public final void testRemoveEmptyNonEmpty() {
        Set<String> s1 = createFromArgs();
        Set<String> s1Expected = createFromArgs();
        Set<String> s2 = createFromArgs("one");
        Set<String> s2Expected = createFromArgs("one");
        Set<String> result = s1.remove(s2);
        Set<String> resultExpected = createFromArgs();
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
        assertEquals(resultExpected, result);
    }

    @Test
    public final void testRemoveNonEmptyNonEmptySubset() {
        Set<String> s1 = createFromArgs("one", "two");
        Set<String> s1Expected = createFromArgs("two");
        Set<String> s2 = createFromArgs("one");
        Set<String> s2Expected = createFromArgs("one");
        Set<String> result = s1.remove(s2);
        Set<String> resultExpected = createFromArgs("one");
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
        assertEquals(resultExpected, result);
    }

    @Test
    public final void testRemoveNonEmptyNonEmptyNonSubset() {
        Set<String> s1 = createFromArgs("two");
        Set<String> s1Expected = createFromArgs("two");
        Set<String> s2 = createFromArgs("one");
        Set<String> s2Expected = createFromArgs("one");
        Set<String> result = s1.remove(s2);
        Set<String> resultExpected = createFromArgs();
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
        assertEquals(resultExpected, result);
    }

    @Test
    public final void testRemoveNonEmptyNonEmptyOverlapping() {
        Set<String> s1 = createFromArgs("one", "two");
        Set<String> s1Expected = createFromArgs("one");
        Set<String> s2 = createFromArgs("two", "three");
        Set<String> s2Expected = createFromArgs("two", "three");
        Set<String> result = s1.remove(s2);
        Set<String> resultExpected = createFromArgs("two");
        assertEquals(s1Expected, s1);
        assertEquals(s2Expected, s2);
        assertEquals(resultExpected, result);
    }

}