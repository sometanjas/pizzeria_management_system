package src.views;

import src.controllers.FrameManager;
import src.controllers.LoginController;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class LoginView extends JPanel implements Observer {
    private FrameManager frameManager;
    JPanel panel = new JPanel();
    private JLabel companyLabel = new JLabel ("Pizza Restaurant Management System");
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private MainMenuPanel mainMenuPanel;

    /* JPasswordField: https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/javax/swing/JPasswordField.html
    Type: char[] -> getPassword() - Returns the text contained in this TextComponent.  */

    public LoginView(FrameManager frameManager, MainMenuPanel mainMenuPanel) {

        super();
        this.frameManager = frameManager;
        this.mainMenuPanel = mainMenuPanel;
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");
        statusLabel = new JLabel();

        // Layout setup
        panel.setBackground(Color.WHITE);
        panel.add(companyLabel);
        panel.setLayout(new GridLayout(4, 1));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(statusLabel);
        panel.setVisible(true);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        add(panel);

    }
    @Override
    public void update(Observable o, Object arg) {
        boolean status = (Boolean) arg;
        if (status) {
            usernameField.setText("");
            passwordField.setText("");
            this.frameManager.showMainView();
            return;
        }
        statusLabel.setText("Username or Password are incorrect!");
    }

    public void addLoginButtonController(LoginController controller) {
        loginButton.addActionListener(controller);

    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}

