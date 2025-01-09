import java.util.Date;
import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<Date> a = new ArrayList<Date>();

        a.add(new Date("3/14/2025"));
        a.add(new Date("8/12/2025"));
        for(int i = 0; i < a.size(); i++) {
            Date d = a.get(i);
            System.out.println(d);
        }
    }

    /*
    public String toString() {
        String s = "ITEM LIST\n";
        for(int i = 0; i < items.size(); i++) {
            Item x = items.get(i);
            s += i + ". " + x + "\n";
        }
        return s;
    }
    */

    }





     */





}
