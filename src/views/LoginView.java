package src.views;

import src.controllers.FrameManager;
import src.controllers.LoginController;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class LoginView extends JPanel implements Observer {
    private FrameManager frameManager;
    private JLabel companyLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private MainMenuPanel mainMenuPanel;

    public LoginView(FrameManager frameManager, MainMenuPanel mainMenuPanel) {
        super(new BorderLayout());
        this.frameManager = frameManager;
        this.mainMenuPanel = mainMenuPanel;

        // Initializing components
        companyLabel = new JLabel("Pizza Restaurant Management System", SwingConstants.CENTER);
        companyLabel.setFont(new Font("Serif", Font.BOLD, 30));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");

        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);

        // Center panel for form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        formPanel.setBackground(Color.WHITE);

        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(loginButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(statusLabel);

        // Center the form panel within the main panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(formPanel);

        // Add components to the main panel
        add(companyLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        boolean status = (Boolean) arg;
        if (status) {
            usernameField.setText("");
            passwordField.setText("");
            this.frameManager.showMainView();
        } else {
            usernameField.setText("");
            passwordField.setText("");
            statusLabel.setText("Username or Password are incorrect!");
        }
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
