public class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int x) {
        this.value = x;
        this.prev = null;
        this.next = null;
    }
}
