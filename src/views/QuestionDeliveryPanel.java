package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionDeliveryPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Pizza Restaurant Management System");
    private JButton deliveryButton = new JButton("Lieferung");
    private JButton pickupButton = new JButton("Selbstabholung");
    private JButton backButton = new JButton("Zurueck");

    public QuestionDeliveryPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.add(companyLabel);
        panel.add(deliveryButton);
        panel.add(pickupButton);
        panel.add(backButton);
        panel.setVisible(true);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        add(panel);

        deliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showPLZ();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });

        pickupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showPickup();
            }
        });
    }
}

