package src;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JLabel companyLabel = new JLabel ("Pizza Restaurant Management System");
    private JLabel usernameLabel = new JLabel ("Username");
    private JTextField usernameInput = new JTextField(20);
    private JLabel passwortLabel = new JLabel ("Passwort");

    /* JPasswordField: https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/javax/swing/JPasswordField.html
    Type: char[] -> getPassword() - Returns the text contained in this TextComponent.  */

    private JPasswordField passwordInput = new JPasswordField(20);
    private JButton loginButton = new JButton("Login");
    public LoginPanel() {

        super();
        setBackground(Color.WHITE);
        add(companyLabel);
        add(usernameLabel);
        add(usernameInput);
        add(passwortLabel);
        add(passwordInput);
        add(loginButton);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 28));
//      if we want to make it more colorful. DONT FORGET TO IMPORT: import javax.swing.border.LineBorder;
//      usernameInput.setBorder(new LineBorder(Color.orange,1));
//      passwortInput.setBorder(new LineBorder(Color.orange,1));
    }
}

