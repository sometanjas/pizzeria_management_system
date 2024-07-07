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

    private JLabel bottomline = new JLabel("Geld auf dem Pizzeria-Konto: ");

    private JLabel einzahlung = new JLabel("Geld auf das Pizzeria-Konto einzahlen (in Cents)");

    private JTextField moneyInput = new JTextField(20);

    private JButton depositMoneyButton = new JButton("Bestaetigen");

    private JButton backButton = new JButton("Zurueck");

    public BookkeepingPanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;
        JPanel panel = new JPanel();
        panel.add(companyLabel);
        panel.add(bottomline);

        panel.add(einzahlung);
        panel.add(moneyInput);
        panel.add(depositMoneyButton);
        panel.add(backButton);
        // Layout setup
        this.refreshData();

        setBackground(Color.WHITE);
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

    public void addDepositMoneyButtonController(BookkeepingController controller) {
        depositMoneyButton.addActionListener(controller);
    }

    public void refreshData() {
        List<TransactionRecord> allTransactions = TransactionsDaoDbImpl.getInstance().getAllTransactions();
        int currentBalance = 0;
        for (TransactionRecord t : allTransactions) {
            currentBalance += t.getValue();
        }

        bottomline.setText(String.format("Geld auf dem Pizzeria-Konto: %d", currentBalance));
    }

    public JTextField getMoneyInput() {
        return moneyInput;
    }
}
