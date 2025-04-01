public class NumberPrinter implements Runnable{
    private String name;

    public NumberPrinter(String n) {
        this.name = n;
    }

    public void run() {
        int printNum = (int) Math.pow(10, 6);
        int maxNum = (int) Math.pow(10, 9);
        for(int i = 1; i <= maxNum; i++) {
            if(i % printNum == 0) {
                System.out.println(this.name + "  at " + i);
            }
        }
    }
}
