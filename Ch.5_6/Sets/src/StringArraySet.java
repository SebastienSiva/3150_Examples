
public class StringArraySet implements StringSet{
    private String[] array;
    private int size = 0; //num string in set
    private int capacity = 10; //initial capacity

    public StringArraySet() {
        this.array = new String[capacity];
    }

    public boolean containsString(String s) {
        return false;
    }

    public void addString(String s) {
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
        for(int i = 0; i < 40; i++) {
            mySet.addString(TestUtil.getRandomName());
        }
        System.out.println(mySet);
    }
}
