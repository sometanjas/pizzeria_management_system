package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PLZErrorPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel lieferungLabel = new JLabel ("Lieferung");
    private JLabel errorLabel = new JLabel ("Postleitzahl liegt außerhalb Berlins! Keine Lieferung möglich!");
    private JButton backToOrderMenuButton = new JButton("Zurück zur Bestellaufnahme");

    public PLZErrorPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        JPanel panel = new JPanel();
        add(panel);
        panel.setBackground(Color.WHITE);
        panel.add(lieferungLabel);
        panel.add(errorLabel);
        panel.add(backToOrderMenuButton);

        lieferungLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

        backToOrderMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showQuestionDelivery();
            }
        });
    }
}

