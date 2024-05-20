package src;

import javax.swing.*;
import java.awt.*;

public class DeliveryDataPanel extends JPanel {
    private JLabel deliveryLabel = new JLabel ("Lieferung");
    private JTextField firstnameInput = new JTextField("Vorname", 20);
    private JTextField secondnameInput = new JTextField("Nachname",20);
    private JTextField addressInput = new JTextField("Strasse + Hausnummer", 20);
    private JTextField floorInput = new JTextField("Etage", 20);
    private JTextField telefonInput = new JTextField("Telefonnummer", 20);
    private JButton nextButton = new JButton("Weiter");
    private JButton killSwitchButton = new JButton("Abbruch");
    public DeliveryDataPanel() {

        super();
        setBackground(Color.WHITE);
        add(deliveryLabel);
        add(firstnameInput);
        add(secondnameInput);
        add(addressInput);
        add(floorInput);
        add(telefonInput);
        add(nextButton);
        add(killSwitchButton);

        deliveryLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));

    }
}

