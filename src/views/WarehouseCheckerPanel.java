package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarehouseCheckerPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel zutatenCheckerLabel = new JLabel ("Warehouse Checker");
    private JLabel errorLabel = new JLabel ("WarehouseCheckerPanel");
    private JLabel notEnoughMessage = new JLabel("Bestellung nicht möglich! Nicht genug Geld.");
    private JButton geldEinzahlen = new JButton("Geld Einzahlen");
    private JLabel alternateOrderLabel = new JLabel("Alternative Bestellung?");
    private JButton yesButton = new JButton("Ja");
    private JButton killswitchButton = new JButton("Nein");

    public WarehouseCheckerPanel(FrameManager frameManager) {
        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(zutatenCheckerLabel);
        add(errorLabel);
        add(notEnoughMessage);
        add(geldEinzahlen);
        add(yesButton);
        add(alternateOrderLabel);
        alternateOrderLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
        add(killswitchButton);

        geldEinzahlen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showBookkeeping();
            }
        });

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showWarehouse();
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

