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

    }

    public int pop() {
        return 0;
    }
}
