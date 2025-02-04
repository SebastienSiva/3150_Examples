import java.util.Arrays;

public class ArraySort {
    public static int stepCounter = 0;

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        for(int ci = 0; ci < c.length; ci++) {
            stepCounter++;
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
        stepCounter++;
        System.arraycopy(nums, 0, a, 0, a.length);
        stepCounter++;
        System.arraycopy(nums, halfway, b, 0, b.length);

        return merge(mergeSort(a), mergeSort(b));
    }

    public static int[] bubbleSort(int[] nums) {
        for(int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                stepCounter++;
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        stepCounter = 0;
        int[] a = MyArrayUtil.randomArray(1000);
        int[] c = bubbleSort(a);
        System.out.println(MyArrayUtil.arrayToString(c));
        System.out.println("bubbleSort took " + stepCounter + " steps");

        stepCounter = 0;
        a = MyArrayUtil.randomArray(1000);
        c = mergeSort(a);
        System.out.println(MyArrayUtil.arrayToString(c));
        System.out.println("mergeSort took " + stepCounter + " steps");

        /*
        int[] a = new int[]{1, 34, 5, 7, 90, 11};
        int[] b = mergeSort(a);
        System.out.println(Arrays.toString(b));
        */

    }
}
