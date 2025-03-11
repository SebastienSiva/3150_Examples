import java.util.LinkedList;

public class StringHashMap implements StringMap{
    //Entry for every hash value
    private LinkedList<Entry>[] buckets;
    private int size = 0; //num strings in set
    private int capacity = 10; //initial capacity
    private double threshHold = 0.75;

    // get value for corresponding key
    public String get(String k) {
        // 1. Get the right bucket using key's hashcode

        // 2. Loop through the bucket looking for entry with matching key

        //3. Return value for matching entry

        //otherwise
        return null;
    }

    public boolean contains(String k) {
        return get(k) != null;
    }

    public void put(String k, String v) {
        if(this.contains(k)) {
            System.out.println("WARNING: " + s + " already in set");
            return; // exit method
        }

        //check and potentially resize # of buckets

        // get the correct bucket and add new entry
        int h = Math.abs(k.hashCode());
        LinkedList<Entry> buck = buckets[h % buckets.length];
        buck.add(new Entry(k, v));
        size++;
    }

    public int size() {
        return size;
    }
}
