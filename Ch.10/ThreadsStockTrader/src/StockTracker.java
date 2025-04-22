import java.text.SimpleDateFormat;
import java.text.NumberFormat;

public class StockTracker implements Runnable{
    private String name;
    private double price;
    private long timeStamp;
    private NASDAQConnectionMgr conMgr;
    private PurchaseRequest pr;

    public StockTracker(String name, NASDAQConnectionMgr conMgrX) {
        this.name = name;
        this.price = -1;
        this.timeStamp = 0;
        this.conMgr = conMgr;
    }

    public void setPr(PurchaseRequest pr) {
        this.pr = pr;
    }

    public void run() {
        while(true) {
            //keep stock value as up to date as possible.
            NASDAQConnection con = conMgr.getAvailableConnection();
            price = con.getStockPrice(name);
            this.timeStamp = System.currentTimeMillis();
            //signal purchase request to check price
            if(pr != null) {
                pr.signalMe(price);
            }

            conMgr.returnConnection(con);
        }
    }

    public String toString() {
        SimpleDateFormat dateStyle = new SimpleDateFormat("MM-dd HH:mm:ss");
        NumberFormat moneyStyle = NumberFormat.getCurrencyInstance();
        return name + " Value: " + moneyStyle.format(price) +
                " @ " + dateStyle.format(timeStamp);
    }
}