package src;

import javax.swing.*;
import java.awt.*;

public class ZutatenCheckerPanel extends JPanel {
    private JLabel zutatenCheckerLabel = new JLabel ("Zutaten Checker");
    private JLabel errorLabel = new JLabel ("Bestellung nicht möglich!");
    private JLabel infoLabel = new JLabel ("Zutaten für Pizza " + "XY" + " nicht vorhanden!");
    private JLabel alternateOrderLabel = new JLabel("Alternative Bestellung?");
    private JButton yesButton = new JButton("Ja");
    private JButton noButton = new JButton("Nein");

    public ZutatenCheckerPanel() {

        super();
        setBackground(Color.WHITE);
        add(zutatenCheckerLabel);
        add(errorLabel);
        add(infoLabel);
        add(alternateOrderLabel);
        add(yesButton);
        add(noButton);
        zutatenCheckerLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
    }
}

