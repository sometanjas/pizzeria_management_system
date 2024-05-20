package src;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private JLabel companyLabel = new JLabel ("Pizza Restaurant Management System");

    private JButton orderPlacement = new JButton("Bestellung aufnehmen");
    private JButton orderHistorie = new JButton("Bestellungs-Historie anzeigen");
    private JButton warehouse = new JButton("Zutaten Bestand");
    private JButton bookkeeping = new JButton("Buchhaltung");
    private JButton logoutButton = new JButton("Logout");
    public MainMenuPanel() {

        super();
        setBackground(Color.WHITE);
        add(companyLabel);
        add(orderPlacement);
        add(orderHistorie);
        add(warehouse);
        add(bookkeeping);
        add(logoutButton);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
//      if we want to make it more colorful. DONT FORGET TO IMPORT: import javax.swing.border.LineBorder;
//      usernameInput.setBorder(new LineBorder(Color.orange,1));
//      passwortInput.setBorder(new LineBorder(Color.orange,1));
    }
}

