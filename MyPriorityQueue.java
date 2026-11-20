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

    private int parent(int index){
        return (index / 2);
    }

    private int leftChild(int index){
        return (2 * index);
    }

    private int rightChild(int index){
        return ((2 * index) + 1);
    }

    public void percolateUp(int index){
        int parentInd = parent(index);
        if (parentInd == 0){
            return;
        }
    /*if item at index is smaller than item at parent (a no no for min heaps) */

        if (comparator.compare(heap.get(parentInd), heap.get(index)) > 0){
            T indexItem = heap.get(index);
            T parentItem = heap.get(parentInd);
            heap.set(parentInd, indexItem);
            heap.set(index, parentItem);
            percolateUp(parentInd);

        }
    }

    public boolean offer(T item){
        heap.add(item);
        percolateUp(heap.size() -1);
        return true;
    }

    public T peek(){
        return null;
    }
    
}

    
