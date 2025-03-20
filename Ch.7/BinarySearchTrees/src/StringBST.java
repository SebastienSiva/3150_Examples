public class StringBST implements StringTree{
    private Node root;
    private int size;

    public StringBST() {
        this.root = null;
        this.size = 0;
    }

    private static boolean rContains(Node n, String s) {
        if(n == null) {
            return false;
        }
        int comp = s.compareTo(n.value);
        if(comp < 0) {
            return rContains(n.left, s);
        }
        else if(comp > 0) {
            return rContains(n.right, s);
        }
        else {
            return true;
        }
    }

    public boolean contains(String s) {
        return rContains(this.root, s);
    }

    //NEVER PASS A NULL NODE TO RINSERT
    private static boolean rInsert(Node n, String s) {
        return false;
    }

    // add the string (if not already there)
    // return true if added
    public boolean insert(String s) {
        if(this.root == null) {
            this.root = new Node(s);
            this.size++;
            return true;
        }
        else {
            boolean b = rInsert(this.root, s);
            if(b == true) {
                this.size++;
            }
            return b;
        }
    }

    public int size() {
        return size;
    }

    private static void rToString(Node n, StringBuilder sb) {
        if(n == null) {
            return;
        }
        rToString(n.left, sb);
        sb.append(n.value + ", ");
        rToString(n.right, sb);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        rToString(this.root, sb);
        String s = sb.toString();
        return "Tree(size=" + this.size + "){" + s.substring(0, s.length()-2) + "}";
    }

    public static void main(String[] args) {
        StringBST tree = new StringBST();
        tree.root = new Node("D");
        tree.root.left = new Node("B");
        tree.root.right = new Node("F");
        tree.root.left.left = new Node("A");
        tree.root.left.right = new Node("C");
        tree.root.right.left = new Node("E");
        tree.root.right.right = new Node("G");

        System.out.println(tree);
    }
}
