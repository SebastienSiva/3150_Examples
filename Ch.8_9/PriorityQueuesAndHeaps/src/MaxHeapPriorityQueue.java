import java.util.Arrays;

public class MaxHeapPriorityQueue implements PriorityQueue{
    private Entry[] heap;
    private int size;

    public MaxHeapPriorityQueue(int capacity) {
        heap = new Entry[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int leftIndex(int i) {
        return (2 * i) + 1;
    }

    private int rightIndex(int i) {
        return (2 * i) + 2;
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        //temp equals something
        Entry temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // check the parent index to see
    // if parent's priority is less than the child's priority
    // then, swap parent and child entries
    // then repeat for parent index
    // stop when parent already larger than child or at the top
    private void bubbleUp(int child_i) {

    }

    public void addEntry(String name, int priority) {
        Entry e = new Entry(name, priority);
        int i = size;
        heap[i] = e;
        size++;
        bubbleUp(i);

        if(size == heap.length) //out of room!
            heap = Arrays.copyOf(heap, size * 2);
    }

    public Entry peek() {
        return heap[0];
    }


    // check the left and right child indexes to see
    // if parent's priority is less than either child's priority
    // then, swap parent and LARGEST child entries
    // then repeat for largest child index
    // stop when parent already larger than children or at bottom (both children's indexes are >= size)
    private void bubbleDown(int parent_i) {

    }

    //remove the highest priority entry
    public Entry poll() {
        Entry e = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = null;
        size--;

        bubbleDown(0);

        return e;
    }

    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        MaxHeapPriorityQueue q = new MaxHeapPriorityQueue(10);
        q.addEntry("Bob", 8);
        q.addEntry("Lisa", 4);
        q.addEntry("Sam", 6);
        q.addEntry("Sally", 9);
        System.out.println(q);
    }
}
