package src.views;

import src.controllers.FrameManager;
import src.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickupDataPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Selbstabholung", SwingConstants.CENTER);
    private JLabel firstnameLabel = new JLabel("Vorname", SwingConstants.CENTER);
    private JTextField firstnameInput = new JTextField(15);
    private JLabel secondnameLabel = new JLabel("Nachname", SwingConstants.CENTER);
    private JTextField secondnameInput = new JTextField(15);
    private JButton nextButton = new JButton("Weiter");
    private JButton killSwitchButton = new JButton("Abbruch");

    public PickupDataPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;
        setBackground(Color.WHITE);

        // Setup delivery label
        deliveryLabel.setFont(new Font("SansSerif", Font.BOLD, 30));

        // Panel for input fields and labels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Center-align the labels, input, and button
        firstnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstnameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondnameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to input panel
        inputPanel.add(firstnameLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(firstnameInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(secondnameLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(secondnameInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(nextButton);

        // Panel for back button
        JPanel backPanel = new JPanel(new BorderLayout());
        backPanel.setBackground(Color.WHITE);
        backPanel.add(killSwitchButton, BorderLayout.WEST);

        // Center the form panel within the main panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(inputPanel);

        // Add components to main panel
        add(deliveryLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(backPanel, BorderLayout.SOUTH);

        // Add action listeners
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order.getInstance().setLieferung(false);
                Order.getInstance().setFirstname(firstnameInput.getText());
                Order.getInstance().setSecondname(secondnameInput.getText());
                Order.getInstance().setPlz(0);
                Order.getInstance().setAddress("");
                Order.getInstance().setFloor("0");
                Order.getInstance().setTelefon("");
                frameManager.showSpeisekarte();
            }
        });

        killSwitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}
