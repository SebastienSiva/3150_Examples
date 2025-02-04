public class RecursionVsLoop {
    //Tips for reverseString
    //.length
    //.charAt...
    //.subString...
    public static int stepCounter = 0;

    public static int fibRecur(int n) {
        if(n <= 1)
            return n;
        stepCounter++;
        return fibRecur(n-1) + fibRecur(n-2);
    }

    public static int fibLoop(int n) {
        int a = 0;
        int b = 1;
        int c = a + b;
        while(n > 2) {
            stepCounter++;
            a = b;
            b = c;
            c = a + b;
            n--;
        }
        return c;
    }

    // n:      1 2 3 4  5
    // fac(n): 1 2 6 24 120
    public static int facLoop(int n) {
        int p = 1;
        for(int i = 2; i <= n; i++) {
            // how many times does this run?
            stepCounter++;
            p = p * i;
        }
        return p;
    }

    public static int facRecur(int n) {
        if(n == 1) {
            return 1;
        }
        stepCounter++;
        return n * facRecur(n - 1);
    }

    public static void main(String[] args) {
        stepCounter = 0;
        System.out.println(fibLoop(30));
        System.out.println("took " + stepCounter + " steps");
        stepCounter = 0;
        System.out.println(fibRecur(50));
        System.out.println("took " + stepCounter + " steps");
        /*
        stepCounter = 0;
        System.out.println(facLoop(15));
        System.out.println("took " + stepCounter + " steps");
        stepCounter = 0;
        System.out.println(facRecur(15));
        System.out.println("took " + stepCounter + " steps");
        //System.out.println(fibRecur(7));
        //System.out.println(facRecur(5));
        */

    }
}