package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PLZErrorPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel lieferungLabel = new JLabel("Lieferung");
    private JLabel errorLabel = new JLabel("Postleitzahl liegt außerhalb Berlins! Keine Lieferung möglich!");
    private JButton backToOrderMenuButton = new JButton("Zurück zur Bestellaufnahme");

    public PLZErrorPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        // Header Panel für "Lieferung"
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(lieferungLabel);

        lieferungLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorLabel.setForeground(Color.RED);

        backToOrderMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headerPanel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(errorLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(backToOrderMenuButton);
        add(Box.createVerticalGlue());

        backToOrderMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showQuestionDelivery();
            }
        });
    }
}
