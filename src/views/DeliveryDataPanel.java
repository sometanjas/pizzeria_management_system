/*package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryDataPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Lieferung");
    private JLabel firstnameLabel = new JLabel("Vorname");
    private JTextField firstnameInput = new JTextField(20);
    private JLabel secondnameLabel = new JLabel("Nachname");
    private JTextField secondnameInput = new JTextField(20);
    private JLabel adressLabel = new JLabel("Strasse + Hausnummer");
    private JTextField addressInput = new JTextField(20);
    private JLabel floorLabel = new JLabel("Etage");
    private JTextField floorInput = new JTextField(20);
    private JLabel telefonLabel = new JLabel("Telefonnummer");
    private JTextField telefonInput = new JTextField(20);
    private JButton nextButton = new JButton("Weiter");
    private JButton killSwitchButton = new JButton("Abbruch");

    public DeliveryDataPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(deliveryLabel);
        add(firstnameLabel);
        add(firstnameInput);
        add(secondnameLabel);
        add(secondnameInput);
        add(adressLabel);
        add(addressInput);
        add(floorLabel);
        add(floorInput);
        add(telefonLabel);
        add(telefonInput);
        add(nextButton);
        add(killSwitchButton);

        deliveryLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

      //  TO-DO
       // nextButton.addActionListener();
        //killSwitchButton.addActionListener();


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

*/

package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryDataPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Lieferung", SwingConstants.CENTER);
    private JLabel firstnameLabel = new JLabel("Vorname");
    private JTextField firstnameInput = new JTextField(20);
    private JLabel secondnameLabel = new JLabel("Nachname");
    private JTextField secondnameInput = new JTextField(20);
    private JLabel adressLabel = new JLabel("Strasse + Hausnummer");
    private JTextField addressInput = new JTextField(20);
    private JLabel floorLabel = new JLabel("Etage");
    private JTextField floorInput = new JTextField(20);
    private JLabel telefonLabel = new JLabel("Telefonnummer");
    private JTextField telefonInput = new JTextField(20);
    private JButton nextButton = new JButton("Weiter");
    private JButton killSwitchButton = new JButton("Abbruch");

    public DeliveryDataPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;
        setBackground(Color.WHITE);

        // Set font for delivery label
        deliveryLabel.setFont(new Font("SansSerif", Font.BOLD, 30));

        // Panel for input fields and labels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 600, 50, 600));

        // Center-align the labels and input fields
        firstnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstnameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondnameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        adressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addressInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        floorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        floorInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        telefonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        telefonInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to input panel
        inputPanel.add(firstnameLabel);
        inputPanel.add(firstnameInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(secondnameLabel);
        inputPanel.add(secondnameInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(adressLabel);
        inputPanel.add(addressInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(floorLabel);
        inputPanel.add(floorInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(telefonLabel);
        inputPanel.add(telefonInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(nextButton);

        // Panel for kill switch button
        JPanel killSwitchPanel = new JPanel(new BorderLayout());
        killSwitchPanel.setBackground(Color.WHITE);
        killSwitchPanel.add(killSwitchButton, BorderLayout.WEST);

        // Add components to main panel
        add(deliveryLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(killSwitchPanel, BorderLayout.SOUTH);

        // Add action listeners
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
