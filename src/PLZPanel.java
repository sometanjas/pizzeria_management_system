package src;

import javax.swing.*;
import java.awt.*;

public class PLZPanel extends JPanel {
    private JLabel deliveryLabel = new JLabel ("Lieferung");

    private JLabel plzLabel = new JLabel ("Geben Sie die PLZ ein");
    private JTextField plzInput = new JTextField(20);
    private JButton checkerButton = new JButton("Checken");
    private JButton backButton = new JButton("Zurueck");
    public PLZPanel() {

        super();
        setBackground(Color.WHITE);
        add(deliveryLabel);
        add(plzLabel);
        add(plzInput);
        add(checkerButton);
        add(backButton);

        deliveryLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

    }
}

