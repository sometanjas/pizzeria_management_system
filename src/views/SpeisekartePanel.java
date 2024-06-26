package src.views;

import src.controllers.FrameManager;
import src.model.Order;
import src.model.OrderItem;
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

    private ArrayList<PizzaInterface> availablePizzas;


    private JButton weiterButton = new JButton("Weiter");
    private JButton killswitchButton = new JButton("Abbruch");

    public SpeisekartePanel(FrameManager frameManager, ArrayList<PizzaInterface> availablePizzas) {
        super();
        this.frameManager = frameManager;
        this.availablePizzas = availablePizzas;
        setBackground(Color.WHITE);
        add(speiseKarteLabel);
        add(pizzaLabel);
        add(preisLabel);
        add(anzahlLabel);
        String pizzalabelText = pizzaLabel.getText();
        String preislabelText = preisLabel.getText();
        String anzahllabelText = anzahlLabel.getText();

        // TO-DO Table

        Object[][] rowData = new Object[this.availablePizzas.size()][3];
        for (int i = 0; i < this.availablePizzas.size(); i++) {
            PizzaInterface ap = this.availablePizzas.get(i);
            rowData[i] = new ArrayList<>(Arrays.asList(
                    new JLabel(ap.getName()),
                    new JLabel(String.valueOf(ap.getPrice())),
                    new JTextField(10)
            )).toArray();
        }

        String[] columnNames = new String[]{pizzalabelText, preislabelText, anzahllabelText};
//        JTable(final Object[][] rowData, final Object[] columnNames)
        JTable table = new JTable(rowData, columnNames);

        add( new JScrollPane( table ));


        speiseKarteLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        pizzaLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        preisLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        anzahlLabel.setFont(new Font("SansSerif", Font.BOLD, 12));

        add(weiterButton);
        weiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        // TODO: create real order items
        ArrayList<OrderItem> items = new ArrayList<>();
        Order.getInstance().setItems(items);
    }
}
