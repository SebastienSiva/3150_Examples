import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        GUI gui = new GUI();

        PurchaseRequest pr = new PurchaseRequest(gui);
        Thread t = new Thread(pr);
        t.start();

        int numConnections = 3;
        NASDAQConnectionMgr conMgr = new NASDAQConnectionMgr(numConnections);
        Map<String, StockTracker> trackers = new HashMap<>();
        for(String s: NASDAQ_DB.getStockNames()) {
            StockTracker track = new StockTracker(s, conMgr);
            new Thread(track).start();
            trackers.put(s, track);
        }

        while(true) {
            int i = 0;
            for(StockTracker track: trackers.values()) {
                gui.setStockLabel(i, track.toString());
                i++;
            }
        }
    }
}