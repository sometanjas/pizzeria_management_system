package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickupDataPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Selbstabholung");
    private JLabel firstnameLabel = new JLabel("Vorname");
    private JTextField firstnameInput = new JTextField(20);
    private JLabel secondnameLabel = new JLabel("Nachname");
    private JTextField secondnameInput = new JTextField(20);
    private JButton nextButton = new JButton("Weiter");
    private JButton killSwitchButton = new JButton("Abbruch");

    public PickupDataPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(deliveryLabel);
        add(firstnameLabel);
        add(firstnameInput);
        add(secondnameLabel);
        add(secondnameInput);

        add(nextButton);
        add(killSwitchButton);

        deliveryLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

        /* TO-DO
        nextButton.addActionListener();
        killSwitchButton.addActionListener();
        */

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showSpeisekarte();
            }
        });


        add(killSwitchButton);

        killSwitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}

