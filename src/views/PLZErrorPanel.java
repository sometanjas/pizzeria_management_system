package src.views;

import javax.swing.*;
import java.awt.*;

public class PLZErrorPanel extends JPanel {
    private JLabel lieferungLabel = new JLabel ("Lieferung");
    private JLabel errorLabel = new JLabel ("Postleitzahl liegt außerhalb Berlins! Keine Lieferung möglich!");
    private JButton backToOrderMenuButton = new JButton("Zurück zur Bestellaufnahme");

    public PLZErrorPanel() {

        super();
        setBackground(Color.WHITE);
        add(lieferungLabel);
        add(errorLabel);
        add(backToOrderMenuButton);
        lieferungLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
    }
}

