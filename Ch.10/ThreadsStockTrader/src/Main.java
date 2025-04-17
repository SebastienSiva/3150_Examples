import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        PurchaseRequest pr = new PurchaseRequest("NVDA", 75);
        Thread t = new Thread(pr);
        t.start();

        int numConnections = 3;
        NASDAQConnectionMgr conMgr = new NASDAQConnectionMgr(numConnections);
        List<StockTracker> trackers = new ArrayList<>();
        for(String s: NASDAQ_DB.getStockNames()) {
            StockTracker track;
            if(s.equals("NVDA")) {
                track = new StockTracker(s, conMgr, pr);
            }
            else {
                track = new StockTracker(s, conMgr, null);
            }
            new Thread(track).start();
            trackers.add(track);
        }

        //NOTE: ADJUST CONSOLE HEIGHT TO MAKE THIS LOOK NICE
        while(true) {
            for(StockTracker track: trackers) {
                System.out.println(track);
            }
            System.out.println();
            Thread.sleep(1100);
        }
    }
}