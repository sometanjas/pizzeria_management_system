package src.views;

import src.controllers.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZutatenCheckerPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel zutatenCheckerLabel = new JLabel("Zutaten Checker");
    private JLabel infoLabel = new JLabel("Zutaten reichen für diese Bestellung nicht aus!");
    private JLabel alternateOrderLabel = new JLabel("Alternative Bestellung?");
    private JButton yesButton = new JButton("Ja");
    private JButton killswitchButton = new JButton("Nein");

    public ZutatenCheckerPanel(FrameManager frameManager) {
        super();
        this.frameManager = frameManager;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        // Header Panel für "Zutaten Checker"
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(zutatenCheckerLabel);

        zutatenCheckerLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        zutatenCheckerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel.setForeground(Color.RED);

        alternateOrderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        killswitchButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(headerPanel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(infoLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(alternateOrderLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(yesButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(killswitchButton);
        add(Box.createVerticalGlue());

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showSpeisekarte();
            }
        });

        killswitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}
