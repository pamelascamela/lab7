import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class MyPriorityQueueTest {
    @Test
    public void offerMaintainsMinHeapOrder(){
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(Comparator.naturalOrder());
        int[] values = {2, 8, 13, 34, 21, 5, 55, 1, 89, 144, 3};

        for (int value : values){
            queue.offer(value);
        }

        Iterator<Integer> iterator = queue.iterator();
        iterator.next();
        List<Integer> actual = new ArrayList<Integer>();
        while (iterator.hasNext()){
            actual.add(iterator.next());
        }

        List<Integer> expected = Arrays.asList(1, 2, 5, 8, 3, 13, 55, 34, 89, 144, 21);
        assertEquals(expected, actual);
    }

    void testPeek() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(Comparator.naturalOrder());
        queue.offer(10);
        queue.offer(20);
        queue.offer(5);

        assertEquals(Integer.valueOf(5), queue.peek());
        
    }
    
}
