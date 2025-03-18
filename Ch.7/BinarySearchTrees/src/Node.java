public class Node {
    public String value;
    public Node left;
    public Node right;

    public Node(String s) {
        this.value = s;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return this.value;
    }

}
