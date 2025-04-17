import java.text.SimpleDateFormat;
import java.text.NumberFormat;

public class StockTracker implements Runnable{
    private String name;
    private double price;
    private long timeStamp;
    private NASDAQConnectionMgr conMgr;

    public StockTracker(String name, NASDAQConnectionMgr conMgr) {
        this.name = name;
        this.price = -1;
        this.timeStamp = 0;
        this.conMgr = conMgr;
    }

    public void run() {
        while(true) {
            //keep stock value as up to date as possible.
            NASDAQConnection con = conMgr.getAvailableConnection();
            price = con.getStockPrice(name);
            this.timeStamp = System.currentTimeMillis();
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