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
    private GUI gui;

    public PurchaseRequest(GUI gui) {
        this.gui = gui;
        this.readyToPurchase = false;
        this.mySignal = new Semaphore(0);
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setMaxPurchasePrice(double maxPurchasePrice) {
        this.maxPurchasePrice = maxPurchasePrice;
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
            gui.setPurchaseStatus("CONNECTING TO BROKER...");
            Thread.sleep(5000); // simulate 5 seconds to connect to broker
            gui.setPurchaseStatus("READY TO PURCHASE!");
            this.readyToPurchase = true;
            mySignal.acquire(); // block and wait on release to make purchase

            //IM ALIVE!!!!
            gui.setPurchaseStatus("PURCHASING " + this.stockName + " : " + this.actualPurchasePrice);
            //System.exit(0); // end the whole program (all threads)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
