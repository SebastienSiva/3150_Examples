import java.util.Date;
public class ArrayEx {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[2] = 9001;
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        Date[] b = new Date[5];
        b[2] = new Date("3/14/2025");
        b[b.length - 1] = new Date("8/12/2025");
        for(int i = 0; i < b.length; i++) {
            Date d = b[i];
            System.out.println(d);
        }
    }
}
