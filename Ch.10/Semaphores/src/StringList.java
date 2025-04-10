import java.util.concurrent.Semaphore;

public class StringList {
    private String[] array;
    private int size;
    private Semaphore datalock;

    public StringList() {
        this.array = new String[10000000]; // 1 million strings!
        this.size = 0;
        this.datalock = new Semaphore(1);
    }

    public void add(String s) {
        //critical section should only allow 1 thread at a time
        // to avoid data corruption.
        try {
            datalock.acquire(); //potentially blocking a thread
            array[size] = s;
            size++;
            datalock.release(); //allowing aby blocked thread to enter
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getSize() {
        return size;
    }

    public String get(int i) {
        return array[i];
    }

    public String toString() {
        return toString(0, 5);
    }

    // Size=100[..."timmy", "sally", "lissa"...]
    public String toString(int a, int b) {
        String r = "Size=" + size + "[...";
        for(int i = a; i < b; i++) {
            r += array[i] + ", ";
        }
        return r + "...]";
    }
}
