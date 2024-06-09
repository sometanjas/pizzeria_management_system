package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookkeepingPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Buchhaltung");

    private JButton backButton = new JButton("Zurueck");

    public BookkeepingPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        JPanel panel = new JPanel();
        panel.add(backButton);

        // Layout setup

        setBackground(Color.WHITE);
        panel.add(companyLabel);
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
