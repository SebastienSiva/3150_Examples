public class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int x) {
        this.value = x;
        this.prev = null;
        this.next = null;
    }

    /* recursive version
    //return "12" or "12, " depending on if we have next
    public String toString() {
        String s = "" + value;
        if(next != null) {
            return s + ", " + next.toString();
        } else {
            return s;
        }
    }
    */
}
