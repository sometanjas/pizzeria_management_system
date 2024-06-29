/*package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.PostLeitZahlChecker.istBerlinPLZ;

public class PLZPanel extends JPanel {

    private Integer convertedTextToInt = 0;

    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel ("Lieferung");
    private JLabel plzLabel = new JLabel ("Geben Sie die PLZ ein");
    private JTextField plzInput = new JTextField(20);
    private JButton checkerButton = new JButton("Checken");
    private JButton backButton = new JButton("Zurueck");

    private JLabel statusLabel;
    public PLZPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        setBackground(Color.WHITE);
        add(deliveryLabel);
        add(plzLabel);
        add(plzInput);
        add(checkerButton);
        add(backButton);
        statusLabel = new JLabel();
        add(statusLabel);
        deliveryLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));


        checkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = plzInput.getText();
                convertedTextToInt = Integer.parseInt(text);
                boolean status = istBerlinPLZ(convertedTextToInt);
                if (status) {
                    frameManager.showDeliveryData();
                    return;
                }
                statusLabel.setText("Postleitzahl liegt außerhalb Berlins! Keine Lieferung möglich!");
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
*/
package src.views;

import src.controllers.FrameManager;
import src.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.PostLeitZahlChecker.istBerlinPLZ;

public class PLZPanel extends JPanel {

    private Integer convertedTextToInt = 0;

    private FrameManager frameManager;
    private JLabel deliveryLabel = new JLabel("Lieferung", SwingConstants.CENTER);
    private JLabel plzLabel = new JLabel("Geben Sie die PLZ ein", SwingConstants.CENTER);
    private JTextField plzInput = new JTextField(10); // Set preferred size by columns
    private JButton checkerButton = new JButton("Checken");
    private JButton backButton = new JButton("Zurueck");
    private JLabel statusLabel = new JLabel("", SwingConstants.CENTER);

    public PLZPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;
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
                try {
                    convertedTextToInt = Integer.parseInt(text);
                    boolean status = istBerlinPLZ(convertedTextToInt);
                    if (status) {
                        Order.getInstance().setPlz(convertedTextToInt);
                        plzInput.setText("");
                        frameManager.showDeliveryData();
                    } else {
                        statusLabel.setText("Postleitzahl liegt außerhalb Berlins! Keine Lieferung möglich!");
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Ungültige Postleitzahl!");
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


