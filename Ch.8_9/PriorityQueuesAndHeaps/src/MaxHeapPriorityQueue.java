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
        return null;
    }

    public Entry poll() {
        return null;
    }
}
