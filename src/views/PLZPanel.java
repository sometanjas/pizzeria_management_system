package src.views;

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

