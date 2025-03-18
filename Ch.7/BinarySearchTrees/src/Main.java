public class Main {

    public static void printLeftRight(Node n) {
        if(n == null) {
            return;
        }
        System.out.print(n);
        printLeftRight(n.left);
        printLeftRight(n.right);
    }

    public static void leftPrintRight(Node n) {
        if(n == null)
            return;
        leftPrintRight(n.left);
        System.out.print(n);
        leftPrintRight(n.right);
    }

    public static void main(String[] args) {
        Node root = new Node("D");
        root.left = new Node("B");
        root.right = new Node("F");
        root.left.left = new Node("A");
        root.left.right = new Node("C");
        root.right.left = new Node("E");
        root.right.right = new Node("G");

        leftPrintRight(root);
    }
}