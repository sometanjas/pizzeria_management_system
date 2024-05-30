package src;

import javax.swing.*;
import java.awt.*;

public class LoginErrorPanel extends JPanel {
    private JLabel companyLabel = new JLabel ("Pizza Restaurant Management System");
    private JLabel errorLabel = new JLabel ("Username or Password are incorrect!");
    private JButton backtologinButton = new JButton("Back to Login");

    public LoginErrorPanel() {
        super();
        setBackground(Color.WHITE);
        add(companyLabel);
        add(errorLabel);
        add(backtologinButton);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
    }
}

