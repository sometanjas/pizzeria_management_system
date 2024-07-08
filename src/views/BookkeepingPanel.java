package src.views;

import src.controllers.BookkeepingController;
import src.controllers.FrameManager;
import src.storage.transactions.TransactionRecord;
import src.storage.transactions.TransactionsDaoDbImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookkeepingPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Buchhaltung");

    private JLabel bottomline = new JLabel("Geld auf dem Pizzeria-Konto: " + "(in Cents)");

    private JLabel einzahlung = new JLabel("Geld auf das Pizzeria-Konto einzahlen (in Cents)");

    private JTextField moneyInput = new JTextField(20);

    private JButton depositMoneyButton = new JButton("Einzahlung bestätigen");

    private JButton backButton = new JButton("Zurück");

    private JLabel wrongInput = new JLabel("");

    public BookkeepingPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;

        // Header Panel
        JPanel headerPanel = new JPanel();
        companyLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        headerPanel.add(companyLabel);
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(headerPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottomline.setFont(new Font("SansSerif", Font.PLAIN, 18));
        bottomline.setAlignmentX(Component.CENTER_ALIGNMENT);

        einzahlung.setFont(new Font("SansSerif", Font.PLAIN, 14));
        einzahlung.setAlignmentX(Component.CENTER_ALIGNMENT);

        moneyInput.setMaximumSize(new Dimension(200, 30));
        moneyInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        depositMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wrongInput.setForeground(Color.RED);
        wrongInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(bottomline);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(einzahlung);
        centerPanel.add(moneyInput);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(depositMoneyButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(wrongInput);

        add(centerPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
        footerPanel.add(Box.createVerticalGlue());
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerPanel.add(backButton);
        footerPanel.add(Box.createVerticalGlue());
        add(footerPanel, BorderLayout.SOUTH);

        // Layout setup
        this.refreshData();
        setBackground(Color.WHITE);
        setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }

    public void addDepositMoneyButtonController(BookkeepingController controller) {
        depositMoneyButton.addActionListener(controller);
    }

    public void refreshData() {
        List<TransactionRecord> allTransactions = TransactionsDaoDbImpl.getInstance().getAllTransactions();
        int currentBalance = 0;
        for (TransactionRecord t : allTransactions) {
            currentBalance += t.getValue();
        }
        moneyInput.setText("");
        bottomline.setText(String.format("Geld auf dem Pizzeria-Konto: %d (in Cents)", currentBalance));
    }

    public JLabel getWrongInput() {
        return wrongInput;
    }

    public JTextField getMoneyInput() {
        return moneyInput;
    }
}
