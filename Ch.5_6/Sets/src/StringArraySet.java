
public class StringArraySet implements StringSet{
    private String[] array;
    private int size = 0; //num strings in set
    private int capacity = 10; //initial capacity
    private double threshHold = 0.75;
    public StringArraySet() {
        this.array = new String[capacity];
    }

    public boolean containsString(String s) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(s))
                return true;
        }
        return false;
    }
    //doubles the capacity
    private void resize() {

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
        array[size] = s;
        size += 1;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String all = "Set{";
        for(int i = 0; i < size; i++) {
            all += array[i] + ", ";
        }
        if(size > 0)
            all = all.substring(0, all.length()-2);
        return all + "}";
    }

    public static void main(String[] args) {
        StringSet mySet = new StringArraySet();
        for(int i = 0; i < 10; i++) {
            mySet.addString(TestUtil.getRandomName());
        }
        System.out.println(mySet);
    }
}
