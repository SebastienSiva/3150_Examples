public class StringBST implements StringTree{
    private Node root;
    private int size;

    private static boolean rContains(Node n, String s) {
        if(n == null) {
            return false;
        }
        int comp = s.compareTo(n.value);

    }

    public boolean contains(String s) {
        return rContains(root, s);
    }

    public boolean insert(String s) {
        return false;
    }

    public int size() {
        return size;
    }
}
