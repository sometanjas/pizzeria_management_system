/*package src.views;

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
*/
package src.views;

import src.controllers.FrameManager;
import src.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionDeliveryPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Pizza Restaurant Management System", SwingConstants.CENTER);
    private JButton deliveryButton = new JButton("Lieferung");
    private JButton pickupButton = new JButton("Selbstabholung");
    private JButton backButton = new JButton("Zurueck");

    public QuestionDeliveryPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;

        // Setup company label
        companyLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Create a panel for the delivery and pickup buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 20, 20)); // 1 row, 2 columns, 20px gap
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Add buttons to the panel
        buttonPanel.add(deliveryButton);
        buttonPanel.add(pickupButton);

        // Add the back button
        JPanel backPanel = new JPanel(new BorderLayout());
        backPanel.setBackground(Color.WHITE);
        backPanel.add(backButton, BorderLayout.WEST);

        // Add components to the main panel
        add(companyLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(backPanel, BorderLayout.SOUTH);

        // Add action listeners
        deliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order.getInstance().setLieferung(true);
                frameManager.showPLZ();
            }
        });

        pickupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order.getInstance().setLieferung(false);
                frameManager.showPickup();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}
