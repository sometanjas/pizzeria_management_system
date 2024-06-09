package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;

public class ZutatenWarningPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel warnungLabel = new JLabel ("Warnung");
    private JLabel errorLabel = new JLabel ("Zutatenmangel!");
    private JLabel infoLabel = new JLabel ("Folgende Zutaten nahen dem Ende zu: ");
    private JLabel zutatenLabel = new JLabel("Tomaten, Käse, Teig...");
    private JButton backToMainMenuButton = new JButton("Zurück zum Hauptmenü");

    public ZutatenWarningPanel(FrameManager frameManager) {
        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(warnungLabel);
        add(errorLabel);
        add(infoLabel);
        add(zutatenLabel);
        add(backToMainMenuButton);
        warnungLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
    }
}

