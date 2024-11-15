package src.views;

import src.controllers.FrameManager;
import src.PostLeitZahlChecker;
import src.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PLZPanel extends JPanel {

    private Integer convertedTextToInt = 0;
    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Lieferung", SwingConstants.CENTER);
    private JLabel plzLabel = new JLabel("Geben Sie die PLZ ein", SwingConstants.CENTER);
    private JTextField plzInput = new JTextField(10); // Set preferred size by columns
    private JButton checkerButton = new JButton("Checken");
    private JButton backButton = new JButton("Zurück");
    private JLabel statusLabel = new JLabel("", SwingConstants.CENTER);

    private PostLeitZahlChecker plzChecker;

    public PLZPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;
        this.plzChecker = new PostLeitZahlChecker();
        setBackground(Color.WHITE);

        // Setup delivery label
        deliveryLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Panel for input and button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(200, 600, 200, 600));

        // Center-align the labels, input, and button
        plzLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        plzInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Add components to input panel
        inputPanel.add(plzLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(plzInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(checkerButton);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(statusLabel);


        // Panel for back button
        JPanel backPanel = new JPanel(new BorderLayout());
        backPanel.setBackground(Color.WHITE);
        backPanel.add(backButton, BorderLayout.WEST);

        // Add components to main panel
        add(deliveryLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(backPanel, BorderLayout.SOUTH);

        // Add action listeners
        checkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = plzInput.getText();
                plzInput.setText("");
                try {
                    int x = Integer.parseInt(text);
                } catch (NumberFormatException f) {statusLabel.setText("Ungültige Eingabe!");
                    statusLabel.setForeground(Color.RED);
                    return;
                }
                boolean status = plzChecker.testPLZ(text);
                if (status) {
                    Order.getInstance().setPlz(Integer.parseInt(text));
                    plzInput.setText("");
                    frameManager.showDeliveryData();
                } else {
                    frameManager.showPLZError();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showQuestionDelivery();
            }
        });
    }
}
