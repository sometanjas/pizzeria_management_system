package src.views;

import src.controllers.FrameManager;
import src.model.NotEnoughIngrsException;
import src.model.Order;
import src.model.OrderItem;
import src.pizza.*;
import src.pizza.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SpeisekartePanel extends JPanel {


    private FrameManager frameManager;
    private JLabel speiseKarteLabel = new JLabel("Speisekarte");
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

    private JTextField margarettaAnzahl = new JTextField(20);
    private JTextField salmoneAnzahl = new JTextField(20);
    private JTextField schinkenAnzahl = new JTextField(20);
    private JTextField tonnoAnzahl = new JTextField(20);
    private ArrayList<PizzaInterface> availablePizzas;


    private JButton weiterButton = new JButton("Weiter");
    private JButton killswitchButton = new JButton("Abbruch");

    //public SpeisekartePanel(FrameManager frameManager, ArrayList<PizzaInterface> availablePizzas) {
    public SpeisekartePanel(FrameManager frameManager) {
        super();
        this.frameManager = frameManager;
        //this.availablePizzas = availablePizzas;
        setBackground(Color.WHITE);

        add(speiseKarteLabel);
        add(pizzaLabel);
        add(preisLabel);
        add(anzahlLabel);


        add(margaretta);
        add(margarettaPreis);
        add(margarettaAnzahl);
        add(salmone);
        add(salmonePreis);
        add(salmoneAnzahl);
        add(schinken);
        add(schinkenPreis);
        add(schinkenAnzahl);
        add(tonno);
        add(tonnoPreis);
        add(tonnoAnzahl);


        speiseKarteLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        pizzaLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        preisLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        anzahlLabel.setFont(new Font("SansSerif", Font.BOLD, 12));

        add(weiterButton);
        weiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PizzaMargaretta margatetta = new PizzaMargaretta();
                PizzaSalmone salmone = new PizzaSalmone();
                PizzaSchinken schinken = new PizzaSchinken();
                PizzaTonno tonno = new PizzaTonno();
                try {
                    margatetta.build();
                    salmone.build();
                    schinken.build();
                    tonno.build();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                ArrayList<OrderItem> items = new ArrayList<>();
                OrderItem margatettaItem = new OrderItem(margatetta, Integer.parseInt(margarettaAnzahl.getText()));
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
                }
                catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                margarettaAnzahl.setText("");
                salmoneAnzahl.setText("");
                schinkenAnzahl.setText("");
                tonnoAnzahl.setText("");
                frameManager.showCustomerReceipt();
            }
        });


        add(killswitchButton);

        killswitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}
