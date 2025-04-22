import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    private JLabel[] stockLabels;

    public GUI() {
        //TOP PANEL
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(640, 120));
        topPanel.setLayout(new GridLayout(5, 1));
        stockLabels = new JLabel[5];
        for(int i = 0; i < 5; i++) {
            stockLabels[i] = new JLabel("Row " + i)
            topPanel.add(stockLabels[i]);
        }

        //create window
        JFrame frame = new JFrame ();

        //add panels to window
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        topPanel.setBorder(border);
        frame.add(topPanel, BorderLayout.NORTH);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle ("STOCK APP");
        frame.pack();
        frame.setVisible(true);

    }
}
