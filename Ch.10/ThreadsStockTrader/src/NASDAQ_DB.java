import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;

//NASDAQ DATABASE IS STATIC and THREADSAFE
//THERE US ONLY 1 COPY AND ANYONE THREAD/CLASS CAN USE IT
public class NASDAQ_DB {
    private static String[] stockTickers = {"AAPL", "META", "MSFT", "NFLX", "NVDA"};
    private static Map<String, Double> db;
    private static Random rgen = new Random();

    private static void setup() {
        if(db == null) {
            db = new Hashtable<>(); // Thread safe map
            for(String s: stockTickers)
                db.put(s, rgen.nextDouble(80, 100));
        }
    }

    public static String[] getStockNames() {
        return stockTickers;
    }

    public static double getPrice(String s) {
        if(db == null) setup();
        double currentPrice = db.get(s);
        db.put(s, currentPrice + rgen.nextDouble(-5, 1)); //stocks are dropping!
        return db.get(s);
    }
}