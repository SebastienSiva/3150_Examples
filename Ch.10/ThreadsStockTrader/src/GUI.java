import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    private JLabel[] stockLabels;
    private JTextField purchaseStock;
    private JTextField purchasePrice;
    private JLabel purchaseStatus;

    public GUI() {
        //set label fonts
        UIManager.put("Label.font", new Font("Courier", Font.PLAIN, 18));

        //TOP PANEL
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(640, 120));
        topPanel.setLayout(new GridLayout(5, 1));
        stockLabels = new JLabel[5];
        for(int i = 0; i < 5; i++) {
            stockLabels[i] = new JLabel("Row " + i);
            topPanel.add(stockLabels[i]);
        }

        //BOTTOM PANEL
        JPanel btmPanel = new JPanel();
        btmPanel.setPreferredSize(new Dimension(640, 120));
        btmPanel.setLayout(new GridLayout(3, 2));
        purchaseStock = new JTextField();
        purchasePrice = new JTextField();
        purchaseStatus = new JLabel("Purchase Status")
        btmPanel.add(new JLabel("Stock To Purchase:"));
        btmPanel.add(purchaseStock);
        btmPanel.add(new JLabel("Purchase Price:"));
        btmPanel.add(purchasePrice);
        btmPanel.add(new JButton("PURCHASE"));
        btmPanel.add(purchaseStatus);

        //create window
        JFrame frame = new JFrame ();

        //add panels to window
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        topPanel.setBorder(border);
        frame.add(topPanel, BorderLayout.NORTH);
        btmPanel.setBorder(border);
        frame.add(btmPanel, BorderLayout.SOUTH);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle ("STOCK APP");
        frame.pack();
        frame.setVisible(true);

    }

    public void setStockLabel(int i, String s) {
        this.stockLabels[i].setText(s);
    }
}
