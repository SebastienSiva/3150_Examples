public class SQIntLinkedList implements IntStack, IntQueue {

    private Node first;
    private Node last;

    public SQIntLinkedList() {
        this.first = null;
        this.last = null;
    }

    //add int onto rear of queue
    public void enqueue(int x) {
        Node n = new Node(x);
        if(first == null) {
            //nothing on list
            first = n;
            last = n;
        }
        else {
            last.next = n;
            n.prev = last;
            last = n;
        }
    }

    //remove int from front of queue
    public int dequeue() {
        return 0;
    }

    public void push(int x) {
        this.enqueue(x);
    }

    public int pop() {
        return 0;
    }

    // return [34, 21, 88]
    public String toString() {
        //with while loop
        Node n = first;
        String s = "[";
        while(n != null) {
            s += n.value;
            if(n.next != null) {
                s += ", ";
            }
            n = n.next;
        }
        s += "]";
        return s;
    }

    /* recursive version
    public String toString() {
        String s = "[";
        if(first != null) {
            s += first.toString();
        }
        s += "]";
        return s;
    }
     */

    public static void main(String[] args) {
        System.out.println("\nQueue enqueues");
        IntQueue queue = new SQIntLinkedList();
        for(int i = 1; i <= 9; i++) {
            int x = i*10;
            queue.enqueue(x);
            System.out.println("Enqueue: " + x + " Queue: " + queue.toString());
        }
    }
}
