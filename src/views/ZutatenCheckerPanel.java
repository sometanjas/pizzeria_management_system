package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZutatenCheckerPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel zutatenCheckerLabel = new JLabel ("Zutaten Checker");
    private JLabel errorLabel = new JLabel ("Bestellung nicht möglich!");
    private JLabel infoLabel = new JLabel ("Zutaten für Pizza " + "XY" + " nicht vorhanden!");
    private JLabel alternateOrderLabel = new JLabel("Alternative Bestellung?");
    private JButton yesButton = new JButton("Ja");
    private JButton killswitchButton = new JButton("Nein");

    public ZutatenCheckerPanel(FrameManager frameManager) {
        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(zutatenCheckerLabel);
        add(errorLabel);
        add(infoLabel);
        add(yesButton);
        add(alternateOrderLabel);
        alternateOrderLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
        add(killswitchButton);

        yesButton.addActionListener(new ActionListener() {
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

