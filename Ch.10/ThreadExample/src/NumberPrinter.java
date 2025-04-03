public class NumberPrinter implements Runnable{
    private String name;
    private int startNum;
    private int stopNum;

    public NumberPrinter(String n, int a, int b) {
        this.name = n;
        this.startNum = a;
        this.stopNum = b;
    }

    public void run() {
        int printNum = (int) Math.pow(10, 6);
        for(int i = startNum; i <= stopNum; i++) {
            if(i % printNum == 0) {
                System.out.println(this.name + "  at " + i);
            }
        }
    }
}
