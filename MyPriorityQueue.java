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
        if (heap.size() == 0){
            return null;
        }
        return heap.get(1);
    }

    private void percolateDown(int index){

        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        //if no children
        if ((heap.size()-1) < leftChildIndex){
            return;
        }
        // if only left Child
        if((heap.size()-1) < rightChildIndex){
            if(comparator.compare(heap.get(index), heap.get(leftChild(index))) > 0){
            T leftItem = heap.get(leftChildIndex);
            T parentItem = heap.get(index);
            heap.set(index, leftItem);
            heap.set(leftChildIndex, parentItem);
            percolateDown(leftChildIndex);
            }
            return;
            }
        

      //if both children finds smaller child
        int smaller = comparator.compare(heap.get(leftChild(index)), heap.get(rightChild(index)));
        
        //if both children same value or left child is smaller
        if (smaller == 0 || smaller < 0){
            //if parent smaller than left child
            if(comparator.compare(heap.get(index), heap.get(leftChild(index))) > 0){
            T leftItem = heap.get(leftChildIndex);
            T parentItem = heap.get(index);
            heap.set(index, leftItem);
            heap.set(leftChildIndex, parentItem);
            percolateDown(leftChildIndex);
            }
            return;
        }
        //else if the right child was smaller
        else{
            if(comparator.compare(heap.get(index), heap.get(rightChild(index))) > 0){
            T rightItem = heap.get(rightChildIndex);
            T parentItem = heap.get(index);
            heap.set(index, rightItem);
            heap.set(rightChildIndex, parentItem);
            percolateDown(rightChildIndex);
        }
        return;
    }
        
    }

    public T poll(){
        T rootVal = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        percolateDown(1);
        return rootVal;
    }
    
}
