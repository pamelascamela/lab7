import java.util.Comparator;

/**
 * The DeadlineComparator class implements a {@link Comparator} for {@link Task}s
 * that compares based on the {@code deadline} instance variable.
 *
 * @author CS Professors
 */
public class LengthComparator implements Comparator<Task> {
	/**
     * Compares two Tasks based on length
     *
     * @param t1 The first task to compare
     * @param t2 The second task to compare
     */
    public int compare(Task t1, Task t2) {
        // compare based on the length instance variable
        if (t1.length == t2.length) {
        	return 0;
        } else if (t1.length < t2.length) {
        	return -1;
        } else {
            // t2 must be greater
            return 1;
        }
    }
}
