package src;

import javax.swing.*;
import java.awt.*;

public class ZutatenWarningPanel extends JPanel {
    private JLabel warnungLabel = new JLabel ("Warnung");
    private JLabel errorLabel = new JLabel ("Zutatenmangel!");
    private JLabel infoLabel = new JLabel ("Folgende Zutaten nahen dem Ende zu: ");
    private JLabel zutatenLabel = new JLabel("Tomaten, Käse, Teig...");
    private JButton backToMainMenuButton = new JButton("Zurück zum Hauptmenü");

    public ZutatenWarningPanel() {
        super();
        setBackground(Color.WHITE);
        add(warnungLabel);
        add(errorLabel);
        add(infoLabel);
        add(zutatenLabel);
        add(backToMainMenuButton);
        warnungLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
    }
}

