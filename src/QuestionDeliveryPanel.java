package src;

import javax.swing.*;
import java.awt.*;

public class QuestionDeliveryPanel extends JPanel {
    private JLabel companyLabel = new JLabel ("Pizza Restaurant Management System");
    private JButton deliveryButton = new JButton("Lieferung");
    private JButton pickupButton = new JButton("Selbstabholung");
    private JButton backButton = new JButton("Zurueck");
    public QuestionDeliveryPanel() {

        super();
        setBackground(Color.WHITE);
        add(companyLabel);
        add(deliveryButton);
        add(pickupButton);
        add(backButton);

        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

    }
}

