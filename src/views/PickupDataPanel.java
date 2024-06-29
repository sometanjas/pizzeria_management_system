/*package src.views;

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

        //TO-DO
       // nextButton.addActionListener();
     //   killSwitchButton.addActionListener();


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
import src.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickupDataPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Selbstabholung", SwingConstants.CENTER);
    private JLabel firstnameLabel = new JLabel("Vorname", SwingConstants.CENTER);
    private JTextField firstnameInput = new JTextField(20);
    private JLabel secondnameLabel = new JLabel("Nachname", SwingConstants.CENTER);
    private JTextField secondnameInput = new JTextField(20);
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
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 600, 200, 600));

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

        // Add components to main panel
        add(deliveryLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
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
