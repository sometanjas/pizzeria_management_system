package src.controllers;
import src.User;
import src.views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private User user;
    private LoginView loginView;


    public LoginController(User user, LoginView view) {
        this.user = user;
        this.loginView = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // check if the credentials are valid. The method will notify the observers
        user.isValidCredentials(loginView.getUsernameField().getText(),
                loginView.getPasswordField().getText());
    }
}
