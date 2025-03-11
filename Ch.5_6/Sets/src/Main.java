import java.util.LinkedList;

public class Main {
    public static int hash(String s) {
        //covert string to unique integer
        return 0;
    }

    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("Bob");
        myList.add("Sally");

        for(String s: myList) {
            System.out.println(s);
        }

        //BAD IDEA BECUASE JUMPING TO INDEX I IS EXPENSIVE IN LINKEDLIST
        /*
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
         */


        /*
        char c = 'A';
        int i = (int) c;
        System.out.println(c + " is " + i);
        */
    }
}