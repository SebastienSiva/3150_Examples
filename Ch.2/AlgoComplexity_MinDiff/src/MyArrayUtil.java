import java.util.Arrays;
import java.util.Random;

public class MyArrayUtil {
    public static int[] randomArray(int size) {
        Random rgen = new Random();
        int[] a = new int[size];
        for(int i = 0; i < a.length; i++) {
            a[i] = rgen.nextInt(size*100);
        }
        return a;
    }

    public static String arrayToString(int[] a) {
        if(a.length <= 5) {
            return Arrays.toString(a); // [23, 32, 1]
        }
        String s = "[";
        for(int i = 0; i < 5; i++) {
            s += a[i] + ", ";
        }
        return s + "...(size: " + a.length + ")]"; //[23, 54, 12, 54, 12, ...(size 100)]
    }

}
