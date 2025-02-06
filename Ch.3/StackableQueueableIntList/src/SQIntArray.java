import java.util.Arrays;

public class SQIntArray implements IntStack, IntQueue{
    private int[] array;

    public SQIntArray() {
        this.array = new int[0];
    }

    public void push(int x) {
        //make new array with size + 1

        //copy over old (use a for loop)

        //add x to end

        //this.array = new_array;
    }

    public int pop() {
        return 0;
    }

    public void enqueue(int x) {

    }

    public int dequeue() {
        return 0;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
