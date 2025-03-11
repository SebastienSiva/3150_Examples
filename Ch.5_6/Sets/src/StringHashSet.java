import java.util.LinkedList;

public class StringHashSet implements StringSet{
    //boolean for every hash value
    private LinkedList<String>[] buckets;
    private int size = 0; //num strings in set
    private int capacity = 10; //initial capacity
    private double threshHold = 0.75;

    public StringHashSet() {
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean containsString(String s) {
        int h = Math.abs(s.hashCode());
        LinkedList<String> bucket = buckets[h % buckets.length];
        return bucket.contains(s);
    }

    private void resize() {
        //TODO: DOUBLE THE CAPACITY OF THE BUCKETS ARRAY
        capacity *= 2;
        //NOTE: BOTH THE BUCKETS AND CAPACITY FIELDS SHOULD BE UPDATED
        //HINT1: CREATE AND INIT A TEMP ARRAY OF LINKEDLISTS
        LinkedList<String>[] temp = new LinkedList[capacity];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = new LinkedList<>();
        }
        //HINT2: COPY OVER OLD VALUES FROM EACH OLD BUCKET TO THE CORRECT NEW BUCKET
        for(int i = 0; i < buckets.length; i++) {
            LinkedList<String> oldBucket = buckets[i];
            //HINT3: REMEMBER TO LOOP THROUGH LINKEDLIST USING ENHANCED FOR LOOP
            for(String s: oldBucket) {
                int h = Math.abs(s.hashCode());
                LinkedList<String> newBucket = temp[h % temp.length];
                newBucket.add(s);
            }
        }
        this.buckets = temp;
    }

    public void addString(String s) {
        if(this.containsString(s)) {
            System.out.println("WARNING: " + s + " already in set");
            return; // exit method
        }

        if(size > capacity * threshHold) {
            resize();
        }

        // add next string
        int h = Math.abs(s.hashCode());
        LinkedList<String> bucket = buckets[h % buckets.length];
        bucket.add(s);
        size += 1;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String all = "Set{";
        for(int i = 0; i < buckets.length; i++) {
            all += buckets[i] + ", ";
        }
        if(size > 0)
            all = all.substring(0, all.length()-2);
        return all + "}";
    }

    public static void main(String[] args) {
        StringSet mySet = new StringHashSet();
        for(int i = 0; i < 40; i++) {
            String n = TestUtil.getRandomName();
            //int hashIndex = Math.abs(n.hashCode()) % 10;
            //System.out.println("Adding: " + n + " at hash index " + hashIndex);
            mySet.addString(n);
        }
        System.out.println(mySet);
    }
}
