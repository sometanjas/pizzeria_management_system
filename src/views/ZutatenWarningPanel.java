package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZutatenWarningPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel warnungLabel = new JLabel ("Warnung");
    private JLabel errorLabel = new JLabel ("Zutatenmangel!");
    private JLabel infoLabel = new JLabel ("Folgende Zutaten nahen dem Ende zu: ");
    private JLabel zutatenLabel = new JLabel("Tomaten, Käse, Teig...");
    private JButton anotherOrder = new JButton("Möchten Sie einen anderen Order abgeben?");
    private JButton killswitchButton = new JButton("Zurück zum Hauptmenü");

    public ZutatenWarningPanel(FrameManager frameManager) {
        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(warnungLabel);
        add(errorLabel);
        add(infoLabel);
        add(zutatenLabel);
        add(anotherOrder);
        warnungLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

        anotherOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showSpeisekarte();
            }
        });

        killswitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}

