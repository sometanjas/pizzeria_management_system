/*
package src.views;


import src.controllers.FrameManager;
import src.controllers.MainMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

    private FrameManager frameManager;
    private MainMenuPanel mainMenuPanel;
    private QuestionDeliveryPanel questionDeliveryPanel;
    private BestellungsHistoriePanel bestellungsHistoriePanel;
    private ZutatenBestandPanel zutatenBestandPanel;
    private BookkeepingPanel bookkeepingPanel;
    private JLabel companyLabel = new JLabel("Pizza Restaurant Management System");
    private JButton orderPlacement = new JButton("Bestellung aufnehmen");
    private JButton orderHistorie = new JButton("Bestellungs-Historie anzeigen");
    private JButton warehouse = new JButton("Zutaten Bestand");
    private JButton bookkeeping = new JButton("Buchhaltung");
    private JButton logoutButton = new JButton("Logout");

    public MainMenuPanel(FrameManager frameManager, QuestionDeliveryPanel questionDeliveryPanel, BestellungsHistoriePanel bestellungsHistoriePanel, ZutatenBestandPanel zutatenBestandPanel, BookkeepingPanel bookkeepingPanel) {

        super();
        this.frameManager = frameManager;
        this.questionDeliveryPanel = questionDeliveryPanel;
        this.bestellungsHistoriePanel = bestellungsHistoriePanel;
        this.zutatenBestandPanel = zutatenBestandPanel;
        this.bookkeepingPanel = bookkeepingPanel;
        setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.add(companyLabel);
        panel.add(orderPlacement);
        panel.add(orderHistorie);
        panel.add(warehouse);
        panel.add(bookkeeping);
        panel.add(logoutButton);
        panel.setVisible(true);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        add(panel);


        orderPlacement.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.QuestionDelivery));
//        orderPlacement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frameManager.showQuestionDelivery();
//            }
//        });
        orderHistorie.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.BestellungsHistorie));
//        orderHistorie.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frameManager.showBestellungsHistorie();
//            }
//        });
        warehouse.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.Warehouse));
//        warehouse.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frameManager.showWarehouse();
//            }
//        });
        bookkeeping.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.Bookkeeping));
//        bookkeeping.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frameManager.showBookkeeping();
//            }
//        });
        logoutButton.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.Logout));
//        logoutButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frameManager.showLogin();
//            }
//        });
    }


}
*/



package src.views;

import src.controllers.FrameManager;
import src.controllers.MainMenuController;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private FrameManager frameManager;
    private QuestionDeliveryPanel questionDeliveryPanel;
    private BestellungsHistoriePanel bestellungsHistoriePanel;
    private ZutatenBestandPanel zutatenBestandPanel;
    private BookkeepingPanel bookkeepingPanel;
    private JLabel companyLabel = new JLabel("Pizza Restaurant Management System", SwingConstants.CENTER);
    private JButton orderPlacement = new JButton("Bestellung aufnehmen");
    private JButton orderHistorie = new JButton("Bestellungs-Historie anzeigen");
    private JButton warehouse = new JButton("Zutaten Bestand");
    private JButton bookkeeping = new JButton("Buchhaltung");
    private JButton logoutButton = new JButton("Logout");

    public MainMenuPanel(FrameManager frameManager, QuestionDeliveryPanel questionDeliveryPanel, BestellungsHistoriePanel bestellungsHistoriePanel, ZutatenBestandPanel zutatenBestandPanel, BookkeepingPanel bookkeepingPanel) {

        super(new BorderLayout());
        this.frameManager = frameManager;
        this.questionDeliveryPanel = questionDeliveryPanel;
        this.bestellungsHistoriePanel = bestellungsHistoriePanel;
        this.zutatenBestandPanel = zutatenBestandPanel;
        this.bookkeepingPanel = bookkeepingPanel;

        // Setup company label
        companyLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Create a panel for the menu buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 20, 20)); // 1 row, 4 columns, 20px gap
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Add buttons to the panel
        buttonPanel.add(orderPlacement);
        buttonPanel.add(orderHistorie);
        buttonPanel.add(warehouse);
        buttonPanel.add(bookkeeping);

        // Add the logout button
        JPanel logoutPanel = new JPanel(new BorderLayout());
        logoutPanel.setBackground(Color.WHITE);
        logoutPanel.add(logoutButton, BorderLayout.WEST);

        // Add components to the main panel
        add(companyLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(logoutPanel, BorderLayout.SOUTH);

        // Add action listeners
        orderPlacement.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.QuestionDelivery));
        orderHistorie.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.BestellungsHistorie));
        warehouse.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.Warehouse));
        bookkeeping.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.Bookkeeping));
        logoutButton.addActionListener(new MainMenuController(frameManager, MainMenuController.Command.Logout));
    }
}
