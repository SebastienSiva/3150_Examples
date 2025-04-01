public class Main {
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        NumberPrinter np = new NumberPrinter("Luffy");
        Thread t1 = new Thread(np);
        t1.start();

        np = new NumberPrinter("Blackjack");
        Thread t2 = new Thread(np);
        t2.start();

        np = new NumberPrinter("Baru");
        Thread t3 = new Thread(np);
        t3.start();

        //wait on all 3 threads to finish.
        t1.join();
        t2.join();
        t3.join();
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println("It took " + (runTime/1000.0) + " seconds");
    }
}