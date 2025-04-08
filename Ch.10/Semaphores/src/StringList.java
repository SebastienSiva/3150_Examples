public class StringList {
    private String[] array;
    private int size;

    public StringList() {
        this.array = new String[1000000]; // 1 million strings!
        this.size = 0;
    }

    public void add(String s) {
        array[size] = s;
        size++;
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
