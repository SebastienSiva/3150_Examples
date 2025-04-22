import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        GUI gui = new GUI();

        //PurchaseRequest pr = new PurchaseRequest("NVDA", 75);
        //Thread t = new Thread(pr);
        //t.start();

        int numConnections = 3;
        NASDAQConnectionMgr conMgr = new NASDAQConnectionMgr(numConnections);
        List<StockTracker> trackers = new ArrayList<>();
        for(String s: NASDAQ_DB.getStockNames()) {
            StockTracker track = new StockTracker(s, conMgr);
            new Thread(track).start();
            trackers.add(track);
        }

        while(true) {
            int i = 0;
            for(StockTracker track: trackers) {
                gui.setStockLabel(i, track.toString());
                i++;
            }
        }
    }
}