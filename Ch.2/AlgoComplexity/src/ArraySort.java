import java.util.ArrayList;
import java.util.Arrays;

public class ArraySort {
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        for(int ci = 0; ci < c.length; ci++) {
            if(ai == a.length) {
                c[ci] = b[bi];
                bi++;
            }
            else if(bi == b.length) {
                c[ci] = a[ai];
                ai++;
            }
            else if(a[ai] < b[bi]) {
                c[ci] = a[ai];
                ai++;
            }
            else {
                c[ci] = b[bi];
                bi++;
            }
        }
        return c;
    }

    public static int[] mergeSort(int[] nums) {
        if(nums.length < 2) {
            return nums;
        }
        int halfway = nums.length / 2;
        int[] a = new int[halfway];
        int[] b = new int[nums.length - halfway];
        System.arraycopy(nums, 0, a, 0, a.length);
        System.arraycopy(nums, halfway, b, 0, b.length);
        return merge(mergeSort(a), mergeSort(b));
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 34, 5, 7, 90, 11};
        int[] b = mergeSort(a);
        System.out.println(Arrays.toString(b));
    }
}
