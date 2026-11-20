import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MyPriorityQueue<T> extends AbstractQueue<T>{
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    public MyPriorityQueue(Comparator<T> comparator){
        this.comparator = comparator;
        this.heap = new ArrayList<T>();
        this.heap.add(null);
    }

    public Comparator<T> getComparator(){
        return comparator;
    }

    public Iterator<T> iterator(){
        return this.heap.iterator();
    }

    public int size(){
        return (heap.size() -1);
    }

    public void clear(){
        heap.clear();
        heap.add(null);
    }

}