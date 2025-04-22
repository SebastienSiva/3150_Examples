import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    public GUI() {
        //TOP PANEL
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(640, 120));


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
