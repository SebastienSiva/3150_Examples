public class StringHashSet implements StringSet{
    //boolean for every hash value
    private boolean[] array;
    private int size = 0; //num strings in set
    private int capacity = 50000; //initial capacity
    private double threshHold = 0.75;

    public StringHashSet() {
        this.array = new boolean[capacity];
    }

    public boolean containsString(String s) {
        int h = Math.abs(s.hashCode());
        return array[h % array.length];
    }

    private void resize() {}

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
        array[h % array.length] = true;
        size += 1;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String all = "Set{";
        for(int i = 0; i < array.length; i++) {
            all += array[i] + ", ";
        }
        if(size > 0)
            all = all.substring(0, all.length()-2);
        return all + "}";
    }

    public static void main(String[] args) {
        StringSet mySet = new StringHashSet();
        for(int i = 0; i < 40; i++) {
            String n = TestUtil.getRandomName();
            int hashIndex = Math.abs(n.hashCode()) % 50000;
            System.out.println("Adding: " + n + " at hash index " + hashIndex);
            mySet.addString(n);
        }
        System.out.println(mySet);
    }
}
