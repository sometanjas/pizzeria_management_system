package src.views;

import src.controllers.FrameManager;
import src.controllers.ZutatenBestandPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZutatenBestandPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Zutaten-Bestellen");
    private JButton bestellenButton = new JButton("Bestellen");
    private JButton backButton = new JButton("Zurueck");

    private JLabel ingrLabel = new JLabel("Ingredients:");
    private JLabel preisLabel = new JLabel("Preis:");
    private JLabel anzahlLabel = new JLabel("Anzahl:");

    private JLabel tomato = new JLabel("Tomaten");
    private JLabel salmone = new JLabel("Salmone");
    private JLabel schinken = new JLabel("Schinken");
    private JLabel tonno = new JLabel("Tonno");
    private JLabel onion = new JLabel("Onion");
    private JLabel dough = new JLabel("Dough");

    private JLabel tomatoPreis = new JLabel("5 Euro / 1 kg");
    private JLabel salmonePreis = new JLabel("20 Euro / 1 kg");
    private JLabel schinkenPreis = new JLabel("12 Euro / 1 kg");
    private JLabel tonnoPreis = new JLabel("12 Euro / 1 kg");
    private JLabel onionPreis = new JLabel("5 Euro / 1 kg");
    private JLabel doughPreis = new JLabel("4 Euro / 1 kg");

    private JTextField tomatoQty = new JTextField(20);
    private JTextField salmoneQty = new JTextField(20);
    private JTextField schinkenQty = new JTextField(20);
    private JTextField tonnoQty = new JTextField(20);
    private JTextField onionQty = new JTextField(20);

    private JTextField doughQty = new JTextField(20);

    public ZutatenBestandPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;

        // Layout setup

        setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.add(companyLabel);

        add(ingrLabel);
        add(preisLabel);
        add(anzahlLabel);

        add(tomato);
        add(tomatoPreis);
        add(tomatoQty);
        add(salmone);
        add(salmonePreis);
        add(salmoneQty);
        add(schinken);
        add(schinkenPreis);
        add(schinkenQty);
        add(tonno);
        add(tonnoPreis);
        add(tonnoQty);
        add(onion);
        add(onionPreis);
        add(onionQty);
        add(dough);
        add(doughPreis);
        add(doughQty);

        panel.add(bestellenButton);
        panel.add(backButton);
        panel.setVisible(true);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        add(panel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }

    public void addBestellenButtonController(ZutatenBestandPanelController controller) {
        bestellenButton.addActionListener(controller);
    }

    public JTextField getTonnoQty() {
        return tonnoQty;
    }

    public JTextField getSchinkenQty() {
        return schinkenQty;
    }

    public JTextField getSalmoneQty() {
        return salmoneQty;
    }

    public JTextField getOnionQty() {
        return onionQty;
    }

    public JTextField getDoughQty() {
        return doughQty;
    }

    public JTextField getTomatoQty() {
        return tomatoQty;
    }
}
