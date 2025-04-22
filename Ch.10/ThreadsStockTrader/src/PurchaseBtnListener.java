import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PurchaseBtnListener implements ActionListener {
    private Map<String, StockTracker> trackers;
    private GUI gui;
    private PurchaseRequest pr;

    public PurchaseBtnListener(Map<String, StockTracker> trackers, GUI gui, PurchaseRequest pr) {
        this.gui = gui;
        this.trackers = trackers;
        this.pr = pr;
    }

    public void actionPerformed(ActionEvent e) {
        this.pr.setStockName(gui.getPurchaseStock());
        this.pr.setMaxPurchasePrice(gui.getPurchasePrice());
        trackers.get(gui.getPurchaseStock()).setPr(pr);
    }
}
