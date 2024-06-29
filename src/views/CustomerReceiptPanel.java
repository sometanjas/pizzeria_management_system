package src.views;

import src.controllers.FrameManager;
import src.model.Order;
import src.model.OrderItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerReceiptPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("CustomerReceipt");

    private JLabel pizzaLabel = new JLabel("Pizza:");
    private JLabel preisLabel = new JLabel("Preis:");
    private JLabel anzahlLabel = new JLabel("Anzahl:");

    private JLabel margaretta = new JLabel("Margaretta");
    private JLabel salmone = new JLabel("Salmone");
    private JLabel schinken = new JLabel("Schinken");
    private JLabel tonno = new JLabel("Tonno");

    private JLabel margarettaPreis = new JLabel("10 Euro");
    private JLabel salmonePreis = new JLabel("15 Euro");
    private JLabel schinkenPreis = new JLabel("12 Euro");
    private JLabel tonnoPreis = new JLabel("12 Euro");


    private JButton backButton = new JButton("Zurueck zum Hauptmenu");

    public CustomerReceiptPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;

        // Layout setup

        setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.add(companyLabel);
        panel.add(backButton);
        panel.setVisible(true);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        add(panel);

//        for (OrderItem item : Order.getInstance().getItems()) {
//            String name = item.getPizza().getName();
//            int anzahl = item.getQuantity();
//            JLabel nameLabel = new JLabel(" " + name);
//            JLabel anzahlLabel = new JLabel(" " + anzahl);
//            add(nameLabel);
//            add(anzahlLabel);
//        }


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });

    }
}

