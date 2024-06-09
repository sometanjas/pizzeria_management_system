package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestellungsHistoriePanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Bestellungshistorie");

    private JButton backButton = new JButton("Zurueck");

    public BestellungsHistoriePanel(FrameManager frameManager) {

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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });

    }
}
