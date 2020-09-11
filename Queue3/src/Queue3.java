import components.queue.QueueSecondary;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
public class Queue3<T> extends QueueSecondary<T> {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Entries included in {@code this}.
     */
    private Sequence<T> entries;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.entries = new Sequence1L<T>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Queue3() {
        this.createNewRep();
    }

    /*
     * Standard methods removed to reduce clutter...
     */

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void enqueue(T x) {
        assert x != null : "Violation of: x is not null";

        // TODO - fill in body
        this.entries.add(this.entries.length(), x);

    }

    @Override
    public final T dequeue() {
        assert this.length() > 0 : "Violation of: this /= <>";

        // TODO - fill in body
        T x = this.entries.remove(0);
        // This line added just to make the component compilable.
        return x;
    }

    @Override
    public final int length() {

        // TODO - fill in body
        int x = this.entries.length();
        // This line added just to make the component compilable.
        return x;
    }

    /*
     * Iterator removed to reduce clutter...
     */
    /**
     * Reports the front of {@code this}.
     *
     * @return the front entry of {@code this}
     * @aliases reference returned by {@code front}
     * @requires this /= <>
     * @ensures <front> is prefix of this
     */
    @Override
    public T front() {
        assert this.length() > 0 : "Violation of: this /= <>";

        T x = this.entries.entry(0);

        return x;

    }

}