public class Main {
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        int maxNum = (int) Math.pow(10, 9);
        String[] names = {"Luffy", "Blackjack", "Baru"};
        for(int i = 0; i < names.length; i++) {
            NumberPrinter np = new NumberPrinter(names[i], (i*maxNum)/3, ((i+1) * maxNum)/3);
            Thread t = new Thread(np);
            t.start();
        }

        //wait on all 3 threads to finish.
        t1.join();
        t2.join();
        t3.join();
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println("It took " + (runTime/1000.0) + " seconds");
    }
}