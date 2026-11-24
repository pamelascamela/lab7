import java.util.Comparator;

/**
 * The DeadlineComparator class implements a {@link Comparator} for {@link Task}s
 * that compares based on the {@code deadline} instance variable.
 * 
 * @author CS Professors
 */
public class DeadlineComparator implements Comparator<Task> {
	/**
     * Compares two Tasks based on deadline
     *
     * @param t1 The first Task to compare
     * @param t2 The second Task to compare

     */
    public int compare(Task t1, Task t2) {
        // compare based on the deadline instance variable
        if (t1.deadline == t2.deadline) {
        	return 0;
        } else if (t1.deadline < t2.deadline) {
        	return -1;
        } else {
            // t2 must be greater
            return 1;
        }
    }
}
