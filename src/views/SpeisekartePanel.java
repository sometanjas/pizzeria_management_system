package src.views;

import src.controllers.FrameManager;
import src.model.NotEnoughIngrsException;
import src.model.Order;
import src.model.OrderItem;
import src.pizza.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpeisekartePanel extends JPanel {

    private FrameManager frameManager;
    private JLabel speiseKarteLabel = new JLabel("Speisekarte");

    private JLabel margaretta = new JLabel("Margaretta: 8,90 Euro");
    private JLabel salmone = new JLabel("Salmone: 15,90 Euro");
    private JLabel schinken = new JLabel("Schinken: 9,00 Euro");
    private JLabel tonno = new JLabel("Tonno: 12,90 Euro");

    private JTextField margarettaAnzahl = new JTextField(20);
    private JTextField salmoneAnzahl = new JTextField(20);
    private JTextField schinkenAnzahl = new JTextField(20);
    private JTextField tonnoAnzahl = new JTextField(20);

    private JButton weiterButton = new JButton("Weiter");
    private JButton killswitchButton = new JButton("Abbruch");

    private JLabel wrongInput = new JLabel("");

    public SpeisekartePanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;
        setBackground(Color.WHITE);

        // Überschrift
        speiseKarteLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        speiseKarteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(speiseKarteLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Hauptinhalt
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 600, 50, 600));

        margaretta.setAlignmentX(Component.CENTER_ALIGNMENT);
        margarettaAnzahl.setAlignmentX(Component.CENTER_ALIGNMENT);
        salmone.setAlignmentX(Component.CENTER_ALIGNMENT);
        salmoneAnzahl.setAlignmentX(Component.CENTER_ALIGNMENT);
        schinken.setAlignmentX(Component.CENTER_ALIGNMENT);
        schinkenAnzahl.setAlignmentX(Component.CENTER_ALIGNMENT);
        tonno.setAlignmentX(Component.CENTER_ALIGNMENT);
        tonnoAnzahl.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(margaretta);
        panel.add(margarettaAnzahl);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(salmone);
        panel.add(salmoneAnzahl);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(schinken);
        panel.add(schinkenAnzahl);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(tonno);
        panel.add(tonnoAnzahl);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(weiterButton);
        panel.add(wrongInput);

        // Panel für Abbruch-Button
        JPanel killSwitchPanel = new JPanel(new BorderLayout());
        killSwitchPanel.setBackground(Color.WHITE);
        killSwitchPanel.add(killswitchButton, BorderLayout.WEST);

        add(panel, BorderLayout.CENTER);
        add(killSwitchPanel, BorderLayout.SOUTH);

        // ActionListener
        weiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PizzaMargaretta margaretta = new PizzaMargaretta();
                    PizzaSalmone salmone = new PizzaSalmone();
                    PizzaSchinken schinken = new PizzaSchinken();
                    PizzaTonno tonno = new PizzaTonno();
                    try {
                        margaretta.build();
                        salmone.build();
                        schinken.build();
                        tonno.build();

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    ArrayList<OrderItem> items = new ArrayList<>();
                    OrderItem margatettaItem = new OrderItem(margaretta, Integer.parseInt(margarettaAnzahl.getText()));
                    if (margatettaItem.getQuantity() > 0) {
                        items.add(margatettaItem);
                    }
                    OrderItem salmoneItem = new OrderItem(salmone, Integer.parseInt(salmoneAnzahl.getText()));
                    if (salmoneItem.getQuantity() > 0) {
                        items.add(salmoneItem);
                    }
                    OrderItem schinkenItem = new OrderItem(schinken, Integer.parseInt(schinkenAnzahl.getText()));
                    if (schinkenItem.getQuantity() > 0) {
                        items.add(schinkenItem);
                    }
                    OrderItem tonnoItem = new OrderItem(tonno, Integer.parseInt(tonnoAnzahl.getText()));
                    if (tonnoItem.getQuantity() > 0) {
                        items.add(tonnoItem);
                    }
                    Order.getInstance().setItems(items);
                    try {
                        Order.getInstance().save();
                    } catch (NotEnoughIngrsException exp) {
                        frameManager.showZutatenCheckerPanel();
                        return;
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    frameManager.showCustomerReceipt();
                } catch (NumberFormatException ex) {
                    wrongInput.setText("Ungültige Eingabe");
                    wrongInput.setForeground(Color.RED);
                }
            }
        });

        killswitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }

    public void refreshData() {
        margarettaAnzahl.setText("");
        salmoneAnzahl.setText("");
        schinkenAnzahl.setText("");
        tonnoAnzahl.setText("");
    }
}
