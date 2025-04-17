import java.util.concurrent.Semaphore;

//SETUP CONNECTION TO BROKER
//WAIT FOR SIGNAL TO BUY FROM STOCKTRACKER
//BUY AS SOON AS PRICE DROPS BELOW MAX PURCHASE PRICE
public class PurchaseRequest implements Runnable{
    private String stockName;
    private double maxPurchasePrice;
    private double actualPurchasePrice;
    private boolean readyToPurchase;
    private Semaphore mySignal;

    public PurchaseRequest(String stockName, double maxPurchasePrice) {
        this.stockName = stockName;
        this.maxPurchasePrice = maxPurchasePrice;
        this.readyToPurchase = false;
        this.mySignal = new Semaphore(0);
    }

    //will be called by the stock tracker for this stock
    public void signalMe(double currentPrice) {
        if(readyToPurchase && currentPrice < maxPurchasePrice) {
            this.actualPurchasePrice = currentPrice;
            //wake up the purchase thread
            mySignal.release();
        }
    }

    public void run() {
        try {
            System.out.println("CONNECTING TO BROKER...");
            Thread.sleep(5000); // simulate 5 seconds to connect to broker
            System.out.println("READY TO PURCHASE!");
            this.readyToPurchase = true;
            mySignal.acquire(); // block and wait on release to make purchase

            //IM ALIVE!!!!
            System.out.println("PURCHASING " + this.stockName + " : " + this.actualPurchasePrice);
            System.exit(0); // end the whole program (all threads)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
